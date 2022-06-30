package EZHome.controller;

import EZHome.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainTestController {

    private final MemberService memberService ;

    @GetMapping(value = "/")
    public String main(Principal principal, Model model){
        if (principal != null) {
            String email = principal.getName() ;
            String username = memberService.userInfo(email) ;

            model.addAttribute("username", username ) ;
        }
        return "common/main_content";
    }

}
