package EZHome.controller;

import EZHome.constant.Role;
import EZHome.dto.MapMainDto;
import EZHome.dto.MemberFormDto;
import EZHome.dto.ReFormDto;
import EZHome.service.MemberService;
import EZHome.service.ReService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/mypage")
@RequiredArgsConstructor
public class mypageController {
    @ModelAttribute("role")
    public Role[] role() {
        return Role.values();
    }
    private final MemberService memberService ;
    private final ReService reService ;

    @GetMapping(value = "/main")
    public String mypageMain(Model model, Principal principal){
        String email = principal.getName();
        MemberFormDto memberFormDto = memberService.getName(email);

        model.addAttribute("memberFormDto", memberFormDto);

        return "admin/myPageMain" ;
    }
}
