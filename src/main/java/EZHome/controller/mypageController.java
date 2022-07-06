package EZHome.controller;

import EZHome.constant.Role;
import EZHome.dto.MemberFormDto;
import EZHome.dto.ReMncsDto;
import EZHome.entity.Member;
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
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping(value = "/mypage")
@RequiredArgsConstructor
public class mypageController {

    private final ConditionService conditionService;
    private final MemberRepository memberRepository;
    @ModelAttribute("role")
    public Role[] role() {
        return Role.values();
    }
    private final MemberService memberService ;
    private final ReService reService ;

    @GetMapping(value = "/USERmain")
    public String gotoMyPage(Model model, Principal principal){
        ReMncsDto reMncsDto = null;
        String email = principal.getName();
        MemberFormDto memberFormDto = memberService.getName(email);

        model.addAttribute("memberFormDto", memberFormDto);
        Member member = memberRepository.findByEmail(email);
        reMncsDto=  conditionService.getMapCondi(member);
        System.out.println("reMncsDto : " + reMncsDto);
        model.addAttribute("myCondi" ,reMncsDto );

        return "admin/USERmyPageMain" ;
    }


}
