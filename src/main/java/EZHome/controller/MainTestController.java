package EZHome.controller;

import EZHome.dto.MemberFormDto;
import EZHome.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainTestController {

    private final MemberService memberService ;

    @GetMapping(value = "/")
    public String main(Principal principal, Model model, HttpSession httpSession){
        if (principal != null || httpSession.getAttribute("username") != null) {
            String email = principal.getName() ;
            String username = memberService.userInfo(email) ;

            model.addAttribute("username", username);

            httpSession.setAttribute("username", username);
        }
        return "common/main_content";
    }

    @GetMapping(value = "/USERmain")
    public String USERmypageMain(Model model, Principal principal){
        String email = principal.getName();
        MemberFormDto memberFormDto = memberService.getName(email);

        model.addAttribute("memberFormDto", memberFormDto);

        return "admin/USERmyPageMain" ;
    }

    @GetMapping(value = "/LREAmain")
    public String LREAmypageMain(Model model, Principal principal){
        String email = principal.getName();
        MemberFormDto memberFormDto = memberService.getName(email);

        model.addAttribute("memberFormDto", memberFormDto);

        return "admin/LREAmyPageMain" ;
    }
}
