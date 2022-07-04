package EZHome.controller;

import EZHome.dto.MapMainDto;
import EZHome.dto.MapSearchDto;
import EZHome.dto.ReFormDto;
import EZHome.dto.ReMncsDto;
import EZHome.entity.Member;
import EZHome.repository.ConditionRepository;
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

   @RequestMapping(value = "/map", method = {RequestMethod.GET, RequestMethod.POST})
    public String main(ReMncsDto reMncsDto,Model model, Principal principal){
        try{
            List<MapMainDto> mapMainDtoList = reService.getItemAll(); //id로 기존에 상품 정보를 formdto에 담기
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

        model.addAttribute("ReMncsDto",new ReMncsDto()); // 회원의 조건 정보를 담고 있음



        //post
        System.out.println("********************************");
        System.out.println("*********컨트롤러 들어왔습니다.*******");
        System.out.println("********************************");

        // 로그인한 인증된 사용자에 대한 정보를 구할 수 있다.
        String email = principal.getName();
//        if(email == null){
//            System.out.println("조건 저장시 로그인 정보가 없다면 발생하는 오류입니다.");
//            model.addAttribute("errorMessage", "로그인을 진행해주세요");
//            return "member/customer/memberLoginForm"; //로그인 폼 이동
//        }

        try{
            conditionService.saveCondi(reMncsDto,email);
        }catch (Exception e){
            model.addAttribute("errorMessage", "조건 저장중에 에러가 발생했습니다.");
            return "common/main_content"; // 메인페이지로
        }

        System.out.println("완료!");


//       return "common/main_content"; // 에러 안남
        return "reEs/html/ReEs";
    }

//    // 회원 조건 저장
//    @PostMapping(value = "/map/save")
//    public String saveCondition( ReMncsDto reMncsDto,Model model, Principal principal){
//
//        System.out.println("********************************");
//        System.out.println("*********컨트롤러 들어왔습니다.*******");
//        System.out.println("********************************");
//
//        // 로그인한 인증된 사용자에 대한 정보를 구할 수 있다.
//        String email = principal.getName();
////        if(email == null){
////            System.out.println("조건 저장시 로그인 정보가 없다면 발생하는 오류입니다.");
////            model.addAttribute("errorMessage", "로그인을 진행해주세요");
////            return "member/customer/memberLoginForm"; //로그인 폼 이동
////        }
//
//        try{
//            conditionService.saveCondi(reMncsDto,email);
//        }catch (Exception e){
//            model.addAttribute("errorMessage", "조건 저장중에 에러가 발생했습니다.");
//            return "common/main_content"; // 메인페이지로
//        }
//
//        System.out.println("완료!");
//
//        return "common/main_content"; // 에러 안남
////        return "reEs/html/ReEs"; // 에러남
//    }


    // 메인 화면에서 상품이미지를 클릭하면 상품 상세페이지로 이동합니다.
    @GetMapping(value="/map/{id}")
    public String gotoDtl(@PathVariable("id") Long DtlId, Model model ){
        ReFormDto reFormDto = reService.getItemUpdate(DtlId);
        Member member = reService.getLrea(DtlId);
        model.addAttribute("DtlItem", reFormDto);
        model.addAttribute("member", member);
        return "reEs/html/InfoDetail";
    }
}
