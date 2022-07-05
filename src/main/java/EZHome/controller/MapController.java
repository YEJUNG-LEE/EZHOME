package EZHome.controller;

import EZHome.dto.MapMainDto;
import EZHome.dto.MapSearchDto;
import EZHome.dto.ReFormDto;
import EZHome.dto.ReMncsDto;
import EZHome.entity.Member;
import EZHome.repository.ConditionRepository;
import EZHome.repository.MemberRepository;
import EZHome.service.ConditionService;
import EZHome.service.MemberService;
import EZHome.service.ReService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MapController {

    private final ReService reService;
    private final MemberRepository memberRepository;
    private final ConditionService conditionService;
//    @GetMapping(value="/map")
//    public String main(MapSearchDto mapSearchDto, Optional<Integer> page, Model model){
//
//        Pageable pageable = PageRequest.of(page.isPresent() ? page.get(): 0, 11);
//
////        if(mapSearchDto.getSearchQuery() != null){
////            if(mapSearchDto.getSearchQuery().equals("null")) {
////                mapSearchDto.setSearchQuery(null);
////            }
////        }
//
//        Page<MapMainDto> items = reService.getMainItemPage(mapSearchDto, pageable);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
//        System.out.println(items.getSize());
//        model.addAttribute("items", items);
//        model.addAttribute("mapSearchDto", mapSearchDto);
//        model.addAttribute("maxPage", 5);
//
//        return "reEs/html/ReEs";
//    }

    @RequestMapping(value = "/map")
    public String main(Model model, Principal principal){
        try{
            List<MapMainDto> mapMainDtoList = reService.getItemAll(); //id로 기존에 상품 정보를 formdto에 담기

            if(principal == null){
                model.addAttribute("ReMncsDto", new ReMncsDto());
            }else{
                String email = principal.getName();
                Member member = memberRepository.findByEmail(email);
                ReMncsDto reMncsDto = conditionService.getMapCondi(member);
                model.addAttribute("ReMncsDto", reMncsDto); // 회원의 조건 정보를 담고 있음
            }
            for (MapMainDto mapMainDto: mapMainDtoList) {
                System.out.println("reFormDto : " + mapMainDto.toString());
                System.out.println("lreaName : " + mapMainDto.getLreaName());
                System.out.println("lreaNick : " + mapMainDto.getLreaNick());
                System.out.println("src : " + mapMainDto.getReImgUrl());
            }
            model.addAttribute("mapMainDtoList", mapMainDtoList); //기존에 등록했던 내용이담긴

        }catch(EntityNotFoundException e){
            model.addAttribute("errorMessage", "존재하지 않는 상품입니다.");
        }
        System.out.println("잘돼요~!");


       return "reEs/html/ReEs";
    }

    // 회원 조건 저장
//    @PostMapping(value = "/map/save")
//    public String saveCondition( ReMncsDto reMncsDto,Model model, Principal principal){
//
//        System.out.println("********************************");
//        System.out.println("*********컨트롤러 들어왔습니다.*******");
//        System.out.println("********************************");
//
//        // 로그인한 인증된 사용자에 대한 정보를 구할 수 있다.
//        String email = principal.getName();
//
//        try{
//            conditionService.saveCondi(reMncsDto,email);
//        }catch (Exception e){
//            model.addAttribute("errorMessage", "조건 저장중에 에러가 발생했습니다.");
//            return "common/main_content"; // 메인페이지로
//        }
//
//        System.out.println("완료!");
//        model.addAttribute("ReMncsDto", reMncsDto);
////        return "common/main_content"; // 에러 안남
//        return "reEs/html/ReEs";
//    }


    // 메인 화면에서 상품이미지를 클릭하면 상품 상세페이지로 이동합니다.
    @GetMapping(value="/map/{id}")
    public String gotoDtl(@PathVariable("id") Long DtlId, Model model ){
        ReFormDto reFormDto = reService.getItemUpdate(DtlId);
        Member member = reService.getLrea(DtlId);
        model.addAttribute("DtlItem", reFormDto);
        model.addAttribute("member", member);
        return "reEs/html/ReEsUpdate";
    }




//
//    // 회원의 지도 조건 정보를 조회하는 메소드를 호출하는 controller
//    @GetMapping(value = "/map/save/{member_id}")
//    public String getTo(@PathVariable("member_id") Long  id,
//                        Model model){
//        try {
//            ReMncsDto reMncsDto = conditionService.getMapCondi(id);
//            System.out.println("************여기는 조건 조회 controller*******");
//            System.out.println("reMncsDto: " +reMncsDto.toString() );
//            model.addAttribute("reMncsDto", reMncsDto);
//        }catch (Exception e){
//            model.addAttribute("errorMessage", "존재하지 않는 회원입니다.");
////            return "member/memberLoginForm" ; // 로그인으로 이동
//            return "reEs/html/ReEsUpdate"; // 업데이트 페이지로 이동
//        }
//
//        return "reEs/html/ReEsUpdate"; // 업데이트 페이지로 이동
//    }



    // 저장된 회원의 조건을 저장하고 수정하고 저장하는 메소드를 호출하는 controller
    @PostMapping(value = "/map/save")
    public String savedCondi(ReMncsDto reMncsDto, Model model, Principal principal ){

        // 로그인한 인증된 사용자에 대한 정보를 구할 수 있다.
        if(principal == null){
            return "member/memberLoginForm" ;
        }
        String email = principal.getName();
        Member member = memberRepository.findByEmail(email);

        try {
            conditionService.updateFilter(reMncsDto, member);
            System.out.println("db에 변경 조건이 저장 되었습니다. 얏호 집에 가세요");
            model.addAttribute("ReMncsDto", reMncsDto);
        }catch (Exception e){
            System.out.println("==========================================================");
            System.out.println(" 조건 updateFilter 서비스로 들어가던 try catch에 걸렸습니다.");
            System.out.println("==========================================================");
            model.addAttribute("errorMessage", "조건 업데이트 등록 중에 오류가 발생했습니다.");
            e.printStackTrace();
            return "redirect:/map";
        }
        return "redirect:/map"; //어디로 가야되지 ? 조건이있는 곳으로 가자 일단.

    }




}
