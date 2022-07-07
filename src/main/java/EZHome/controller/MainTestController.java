package EZHome.controller;

import EZHome.dto.MapMainDto;
import EZHome.dto.MemberFormDto;
import EZHome.dto.ReFormDto;
import EZHome.dto.ReMncsDto;
import EZHome.entity.Member;
import EZHome.repository.MemberRepository;
import EZHome.service.ConditionService;
import EZHome.service.MemberService;
import EZHome.service.ReService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainTestController {

    private final MemberService memberService ;
    private final ReService reService;
    private final MemberRepository memberRepository;
    private final ConditionService conditionService;

    @GetMapping(value = "/")
    public String main(Principal principal, Model model, HttpSession httpSession) {

        //로그인 했을시
        if (principal != null || httpSession.getAttribute("username") != null) {
            String email = principal.getName();
            String username = memberService.userInfo(email);

            model.addAttribute("username", username);
            httpSession.setAttribute("username", username);


            // 매물 정보를 가져온다.
            List<MapMainDto> mapMainDtoList = reService.getItemAll();
            // 회원 객체를 가져온다.
            Member member =memberRepository.findByEmail(email);
            System.out.println("compare02들어가기전");
            mapMainDtoList = conditionService.compare02(member,mapMainDtoList);

            model.addAttribute("mapMainDtoList",mapMainDtoList);
            System.out.println("***************************************************8");
            System.out.println("mapMainDtoList : " + mapMainDtoList);
            System.out.println("***************************************************8");
            return "common/main_content";

        }else{   // 로그인 안했을시
            List<MapMainDto> RecommandList = reService.getItemAll();
            model.addAttribute("RecommandList",RecommandList);
            System.out.println("=================================sssssss");
            System.out.println("RecommandList.size() : " + RecommandList.get(0).getPercent());
            System.out.println("RecommandList.size() : " + RecommandList.get(1).getPercent());
            System.out.println("=================================sssssss");

            return "common/main_content";
        }

        // 로그인 안했을시

    }


//    @GetMapping(value = "/USERmain")
//    public String USERmypageMain(Model model, Principal principal){
//        String email = principal.getName();
//        MemberFormDto memberFormDto = memberService.getName(email);
//
//        model.addAttribute("memberFormDto", memberFormDto);
//
//        return "admin/USERmyPageMain" ;
//    }

//    @GetMapping(value = "/LREAmain")
//    public String LREAmypageMain(Model model, Principal principal){
//        String email = principal.getName();
//        MemberFormDto memberFormDto = memberService.getName(email);
//
//        model.addAttribute("memberFormDto", memberFormDto);
//
//        return "admin/LREAmyPageMain" ;
//    }

}
