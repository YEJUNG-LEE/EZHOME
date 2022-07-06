package EZHome.controller;

import EZHome.dto.MemberFormDto;
import EZHome.dto.ReFormDto;
import EZHome.service.MemberService;
import EZHome.service.ReService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainTestController {

    private final MemberService memberService ;
    private final ReService reService;

    @GetMapping(value = "/")
    public String main(Principal principal, Model model, HttpSession httpSession, @PathVariable("id") Long id){
        if (principal != null || httpSession.getAttribute("username") != null) {
            String email = principal.getName() ;
            ReFormDto reFormDto = reService.getItemDtl(id);
            MemberFormDto memberFormDto = memberService.getMemAddress(membAddress1);
            String username = memberService.userInfo(email) ;

            model.addAttribute("username", username);
            model.addAttribute("address", reFormDto);

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
