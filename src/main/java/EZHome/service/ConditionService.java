package EZHome.service;

import EZHome.dto.MapMainDto;
import EZHome.dto.ReMncsDto;
import EZHome.entity.*;
import EZHome.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ConditionService {

    private final ConditionRepository conditionRepository;
    private final MemberRepository memberRepository;
    private final ReEsRepository reEsRepository;
    private final ReCucsRepository reCucsRepository;
    private final ReCacsRepository reCacsRepository;




//    // 조건 저장
//    public Long saveCondi(ReMncsDto reMncsDto, String email){
//
//        System.out.println("********************************");
//        System.out.println("*********서비스 들어왔습니다.*******");
//        System.out.println("********************************");
//
//        MapFilter mapFilter = reMncsDto.creatMapFilter();
//        Member member = memberRepository.findByEmail(email);
//        mapFilter.setMember(member);
//        conditionRepository.save(mapFilter);
//
//        return mapFilter.getId();
//    }



    // 회원의 조건 정보를 조회하는 메소드
    public ReMncsDto getMapCondi(Long id){
        // 조건의 id를 가지고 DB에 저장된 정보를 get하는 과정
        MapFilter mapFilter  = conditionRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        // of 메소드를 사용해서 id로 조회한 등록된 mapfilter 정보들을
        // 화면에 띄우기 위해서 = entity -> Dto
        ReMncsDto reMncsDto = ReMncsDto.of(mapFilter);

        // reMncsDto에 of로 매핑을 시켰으니까, reMncsDto의 toString()를 통해서 나오는지 확인해주고
        System.out.println("db에 저장되었던 조건 정보 entity -> dto" + reMncsDto.toString());


        return reMncsDto ;  // 리턴 ~
    }
    public ReMncsDto getMapCondi(Member member){
        // 조건의 id를 가지고 DB에 저장된 정보를 get하는 과정
        MapFilter mapFilter  = conditionRepository.findByMember_Id(member.getId());

        // of 메소드를 사용해서 id로 조회한 등록된 mapfilter 정보들을
        // 화면에 띄우기 위해서 = entity -> Dto
        if(mapFilter == null){
            return new ReMncsDto();
        }
        ReMncsDto reMncsDto = ReMncsDto.of(mapFilter);

        // reMncsDto에 of로 매핑을 시켰으니까, reMncsDto의 toString()를 통해서 나오는지 확인해주고
        System.out.println("db에 저장되었던 조건 정보 entity -> dto" + reMncsDto.toString());


        return reMncsDto ;  // 리턴 ~
    }


    // 회원의 조건 정보를 수정 저장 하는 메소드
    public void updateFilter(ReMncsDto reMncsDto, Member member){
        System.out.println("*****************************");
        System.out.println("*조건 정보 서비스 입니다*********");
        System.out.println("*****************************");

        MapFilter mapFilter = null;

        // 멤버id와 관련된 MapFilter 조건의 id를 가져오세요.
         mapFilter = conditionRepository.findByMember_Id(member.getId());

        if(mapFilter == null){ // 새로만들기
            System.out.println("********************************");
            System.out.println("*********서비스 들어왔습니다.*******");
            System.out.println("********************************");


            mapFilter = reMncsDto.creatMapFilter();
            member = memberRepository.findByEmail(member.getEmail());
            mapFilter.setMember(member);
            conditionRepository.save(mapFilter);


        }else{  // 업데이트
            Long condiId =  mapFilter.getId();
            System.out.println("condiId : " + condiId);
            System.out.println("condiId 오류안남************************************************");

            // 멤버의 고유 값 email을 가져오세요
            System.out.println("member : " + member);
            System.out.println("member 오류안남************************************************");

            // 1. 수정 조건을 등록 하겠습니다.
            // Dto의 정보를 entity로 변경하고 ( createReEs() : reMncsDto(Dto) -> mapFilter(Entity) )
             mapFilter = reMncsDto.creatMapFilter();
            System.out.println("mapFilter : " + mapFilter);
            System.out.println("mapFilter 오류안남************************************************");


            // 2. 회원 정보를 mapFilter에 작성하여 둘 관계를 연결 합니다.
            mapFilter.setMember(member);

            // 3. 조건의 id에, 회원의 id로 작성되었던 id(=condiId)를 넣어줍니다.
            mapFilter.setId(condiId);
            System.out.println("mapFilter.toString()" + mapFilter.toString());

            //3. 조건 정보를 저장
            conditionRepository.save(mapFilter);
            System.out.println("save(mapFilter) 오류안남");
        }

    }


    public List<MapMainDto> compare(ReMncsDto reMncsDto, List<MapMainDto> mapMainDtoList) {
        if(reMncsDto == null){
            return mapMainDtoList;
        }else if(reMncsDto.getId() == null){
            return mapMainDtoList;
        }
        System.out.println("compare에 들어갔습니다.");
        List<MapMainDto> result = new ArrayList<MapMainDto>();  // 회원 조건에 맞는 매물만 담겨질 List
        List<MapMainDto> rankList = new ArrayList<MapMainDto>();    // result에 순위를 매겨서 반환할 List(최종)
        Map<String, Integer> match = new HashMap<String, Integer>();  // 선택한 조건의 갯수(select)와 맞는 부분(correct)을 반환할 Map
        Map<Integer, Integer> rank = new HashMap<Integer, Integer>();   // rank의 index를 담을 Map

        for (MapMainDto mapMainDto : mapMainDtoList) {
            ReEs reEs = reEsRepository.findById(mapMainDto.getId()).orElseThrow(EntityNotFoundException::new);
            boolean flag = reEs.compare(reMncsDto);
            if(flag){
                ReCucs reCucs = reCucsRepository.findByReEs_Id(mapMainDto.getId());
                ReCacs reCacs = reCacsRepository.findByReEs_Id(mapMainDto.getId());
                match = reCucs.compare(reMncsDto, match);
                match = reCacs.compare(reMncsDto, match);
                int select = match.get("select");
                int correct = match.get("correct");
                int percent = (int)Math.round(100.0*correct/select);
                mapMainDto.setSelect(select);
                mapMainDto.setCorrect(correct);
                mapMainDto.setPercent(percent);
                System.out.println("선택한 부분 : " + (match.get("select")));
                System.out.println(reEs.getId() + "의 맞는 부분 : " + match.get("correct"));
                System.out.println(reEs.getId() + "의 퍼센트 : " + percent);
                result.add(mapMainDto);
            }
        }
        int index = 0;
        for (MapMainDto mapMainDto: result) {
            rank.put(mapMainDto.getPercent(), index);
            index += 1;
        }
        List<Integer> keySet = new ArrayList<>(rank.keySet());
        keySet.sort(Comparator.reverseOrder());
        System.out.println("====내림차순 정렬===");
        int ranking = 1;
        for(int key : keySet){
            System.out.println("Key:" + key + ", value : " + rank.get(key));
            result.get(rank.get(key)).setRank(ranking);
            rankList.add(result.get(rank.get(key)));
            ranking += 1;
        }
        return rankList;
    }

    public List<MapMainDto> compare02(Member member, List<MapMainDto> mapMainDtoList) {
        System.out.println("compare에 들어갔습니다.");
        // 회원 주소와 매물 주소가 일치한 매물만 담을 List
        List<MapMainDto> memberReESList = new ArrayList<MapMainDto>();

        int index =0 ;
        for (MapMainDto mapMainDto : mapMainDtoList) {
            System.out.println("회원 도로명 주소" + member.getMembAddress1());
            System.out.println("매물 도로명 주소" + mapMainDto.getRoadAddress());
           String memberAddress = member.getMembAddress1().split(" ")[1]; // 땡떙구
            System.out.println("memberAddress : " + memberAddress);
            String reEsAddress = mapMainDto.getRoadAddress().split(" ")[1]; // 땡떙구
            System.out.println("reEsAddress : " + reEsAddress);

            if(index <= 3){
                if(memberAddress.equals(reEsAddress)){
                    System.out.println("회원주소와 매물 주소 일치");
                    memberReESList.add(mapMainDto);
                    index += 1;
                }
            }else{
                break;
            }

        }
        return memberReESList;
    }
}
