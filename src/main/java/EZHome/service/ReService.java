package EZHome.service;

import EZHome.dto.MapMainDto;
import EZHome.dto.MapSearchDto;
import EZHome.dto.ReFormDto;
import EZHome.dto.ReImgDto;
import EZHome.entity.*;
import EZHome.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReService {

    private final ReEsRepository reEsRepository;
    private final MemberRepository memberRepository;
    private final ReImgService reImgService;
    //상품 등록 폼에서 입력 받은 데이터(Dto)를 이용하여  상품 데이터(entity)를 저장시키고,
    // 반 복문을 사용하여 상품에 따른 이미지들을 저장합니다.
    private final ReCacsRepository reCacsRepository;
    private final ReCucsRepository reCucsRepository;

    public Long savedReEs(ReFormDto reFormDto, List<MultipartFile> itemImgFileList, String email) throws Exception {
//        System.out.println("======================================");
////        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
//        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        System.out.println("======================================");
        System.out.println("============서비스로 들어갔습니다=========");
        System.out.println("======================================");

        // 1. 상품등록 ( createReEs() : Dto -> Entity )
        ReEs reEs = reFormDto.createReEs();
        Member member = memberRepository.findByEmail(email);
        reEs.setMember(member);
        System.out.println("createReEs 오류안남");

        reEsRepository.save(reEs); // 매물 상품 데이터 저장

        System.out.println("save(reEs) 오류안남");
        /*종욱*/
        // 매물 커스텀 데이터 저장
        // 매물 카테고리 데이터 저장

        ReCucs reCucs = reFormDto.createReCucs();
        reCucs.setReEs(reEs);
        System.out.println("createReCucs 오류안남");

        ReCacs reCacs = reFormDto.createReCacs();
        reCacs.setReEs(reEs);
        System.out.println("createReCacs 오류안남");
        reCucsRepository.save(reCucs);
        reCacsRepository.save(reCacs);


        // 2. 상품 이미지 등록
        // 반복문으로 해당 상품(ReEs)과 관련된 이미지(ReImg)들 저장하기
        for (int i = 0; i < itemImgFileList.size(); i++) {
            ReImg reImg = new ReImg();

            reImg.setReEs(reEs);
            if(i == 0 ){
                reImg.setReYN("Y"); //대표이미지
            }else{
                reImg.setReYN("N"); //나머지 이미지
            }

            // 상품의 이미지 정보를 저장합니다.
            reImgService.savedItemImg(reImg, itemImgFileList.get(i));

        } // end for다 ~

        return reEs.getId();
    }

    private final ReEsImgRepository reEsImgRepository;

    //디테일 페이지
    @Transactional(readOnly = true)
    public ReFormDto getItemDtl(Long id){
        List<ReImg> itemImgList = reEsImgRepository.findByReEs_IdOrderByIdAsc(id);

        // 3. dto를 저장시킬 리스트 컬렉션 생성 ( dto -> Jpa 연동)
        List<ReImgDto> reImgDtoList = new ArrayList<ReImgDto>();

        // 수정페이지는 기존 등록정보가 화면에 띄어져야 하므로
        // 반복문을 사용하여 entity를 dto로 변경시켜 컬렉션에 답습니다.

        for(ReImg reImg: itemImgList){
            // 타입이 다름으로 of()메소드를 이용해 itemImg(entity)-> dto 타입으로 변경
            ReImgDto reImgDto = ReImgDto.of(reImg);

            // 수정이므로 비어있는 화면이미지 lIST 컬렉션에, 기존에 담겨 있던 등록이미지를 넣어 표현합니다.
            reImgDtoList.add(reImgDto);
        }

        //4. 상품 entity 정보를 구합니다.
        ReEs reEs = reEsRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        //5. of() 메소드를 사용해서 id로 조회한 등록된 item entity 정보들을 dto로 변경 ->
        // 이유 : 화면에 넣기 위해서
        ReFormDto reFormDto = ReFormDto.of(reEs);

        // 6 setItemImgDtoList() :
        //상품 등록시 첨부할 상품 이미지 정보들을
        // 저장할 리스트 컬렉션으로 화면에 기재가 됨(최대 5개 이미지)
        reFormDto.setReImgDtoList(reImgDtoList);
        System.out.println("이미지 리턴");
        return reFormDto;
    }

//    // 메인 페이지에 보여줄 상품 데이터를 조회하는 메소드를 구현합니다.
//    @Transactional(readOnly = true)
//    public Page<MapMainDto> getMainItemPage(MapSearchDto mapSearchDto, Pageable pageable){
//        return reEsRepository.getMainItemPage(mapSearchDto,pageable);
//    }

    public ReFormDto getItemUpdate(Long id){
        List<ReImg> itemImgList = reEsImgRepository.findByReEs_IdOrderByIdAsc(id);

        for (ReImg reImg: itemImgList) {
            System.out.println("itemImgList : " + reImg.getId());
        }

        List<String> reOriNmList = new ArrayList<String>();

//         수정페이지는 기존 등록정보가 화면에 띄어져야 하므로
//         반복문을 사용하여 entity를 dto로 변경시켜 컬렉션에 답습니다.
        for(ReImg reImg: itemImgList){
            // 타입이 다름으로 of()메소드를 이용해 itemImg(entity)-> dto 타입으로 변경
            System.out.println("============================================");
            System.out.println("ReImgDto.of 전");
            ReImgDto reImgDto = ReImgDto.of(reImg);
            System.out.println("ReImgDto.of 후");
            System.out.println("============================================");

            // 수정이므로 비어있는 화면이미지 lIST 컬렉션에, 기존에 담겨 있던 등록이미지를 넣어 표현합니다.
            reOriNmList.add(reImgDto.getReOriNm());
        }

        //4. 상품 entity 정보를 구합니다.
        ReEs reEs = reEsRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        ReCucs recucs = reCucsRepository.findByReEs_Id(id);
        ReCacs recacs = reCacsRepository.findByReEs_Id(id);

        System.out.println("recucs : " + recucs.toString());
        System.out.println("recacs : " + recacs.toString());

        //5. of() 메소드를 사용해서 id로 조회한 등록된 item entity 정보들을 dto로 변경 ->
        // 이유 : 화면에 넣기 위해서
        ReFormDto reFormDto = ReFormDto.ofReEs(reEs);
        reFormDto = ReFormDto.ofReCucs(reFormDto, recucs);
        reFormDto = ReFormDto.ofReCacs(reFormDto, recacs);
        // reFormDto에 of로 매핑을 시켰으니까, reFromDto의 toString()를 통해서 나오는지 확인해주고
        System.out.println("여기에는 출력됩니까?");
        System.out.println(reFormDto.toString());
        // html이랑 연결도 해보고

        reFormDto.setReOriNmList(reOriNmList);
        System.out.println("이미지 리턴");
        return reFormDto;
    }


    public List<MapMainDto> getItemAll() {
        List<MapMainDto> mapMainDtoList = new ArrayList<MapMainDto>();
        // 1. repository를 통해 ReES에 있는 모든 데이터를 객체로 불러온다
        List<ReEs> reEsList = reEsRepository.findAll();
        // 2. ReFormDto와 Of를 통해 매핑시킨다.
        for (ReEs reEs :reEsList) {
            Long id = reEs.getId();
            List<ReImg> reImgList = reEsImgRepository.findByReEs_IdOrderByIdAsc(id);
            String imgUrl = "";
            for (ReImg reImg:reImgList) {
                System.out.println("서비스 이미지 경로" + reImg.getReImgUrl());
                if(reImg.getReYN().equals("Y")){
                    imgUrl = reImg.getReImgUrl();
                    System.out.println("대표 이미지 경로 : " + reImg.getReImgUrl());
                }
            }
            Member member = reEs.getMember();
            String name = member.getMembName();
            String nick = member.getMembNick();
            MapMainDto mapMainDto = MapMainDto.of(reEs);
            mapMainDto.setLreaName(name);
            mapMainDto.setLreaNick(nick);
            mapMainDto.setReImgUrl(imgUrl);
            mapMainDtoList.add(mapMainDto);
        }

        return mapMainDtoList;
    }

    public Member getLrea(Long id){
        // repository 매물아이디로 reEs 엔터티 객체를 가져온다
        ReEs reEs = reEsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        // reEs.get올린사람아이디를 가져온다
        Member member = reEs.getMember();
        // 그 아이디로 Member member 객체를 반환한다.
        System.out.println("공인중개사 아이디 : " + member.getMembNick());
        return member;
    }

    public void updateReEs(ReFormDto reFormDto, Long reId, List<MultipartFile> itemImgFileList) {
        System.out.println("======================================");
        System.out.println("============서비스로 들어갔습니다=========");
        System.out.println("======================================");
        Long cuId = reCucsRepository.findByReEs_Id(reId).getId();
        Long caId = reCacsRepository.findByReEs_Id(reId).getId();

        // 1. 상품등록 ( createReEs() : Dto -> Entity )
        ReEs reEs = reFormDto.createReEs();
        ReCucs reCucs = reFormDto.createReCucs();
        ReCacs reCacs = reFormDto.createReCacs();
        reCucs.setReEs(reEs);
        reCacs.setReEs(reEs);
        reCucs.setId(cuId);
        reCacs.setId(caId);
        System.out.println("reEs : " + reEs.toString());
        System.out.println("reCucs : " + reCucs.toString());
        System.out.println("reCacs : " + reCacs.toString());


        reEsRepository.save(reEs); // 매물 상품 데이터 저장
        System.out.println("save(reEs) 오류안남");
        reCucsRepository.save(reCucs); // 매물 맞춤 데이터 저장
        System.out.println("save(reCucs) 오류안남");
        reCacsRepository.save(reCacs); // 매물 카테고리 데이터 저장
        System.out.println("save(reCacs) 오류안남");




        List<ReImg> reImgList = reImgService.getAll(reId);
        // 2. 상품 이미지 등록
        // 우선 이미지를 변경하였는지 확인하고, 넣었다면 그 부분만 변경한다
        for (int i = 0; i < itemImgFileList.size(); i++) {
            ReImg reImg = reImgList.get(i);
            ReImg newReImg = new ReImg();
            newReImg.setReEs(reEs);
            System.out.println("reImg : " + reImg.toString());
            if(i == 0 ){
                reImg.setReYN("Y"); //대표이미지
            }else{
                reImg.setReYN("N"); //나머지 이미지
            }

            // 상품의 이미지 정보를 저장합니다.
            try {
                reImgService.deleteItemImg(reImg);
                reImgService.savedItemImg(newReImg, itemImgFileList.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } // end for다 ~
    }
}