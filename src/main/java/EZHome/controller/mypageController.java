package EZHome.controller;

import EZHome.constant.Role;
import EZHome.dto.*;
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
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/mypage")
@RequiredArgsConstructor
public class mypageController {

    private final ConditionService conditionService;
    private final MemberRepository memberRepository;
    private final MemberService memberService ;
    private final ReService reService ;

    @ModelAttribute("role")
    public Role[] role() {
        return Role.values();
    }

    @GetMapping(value = "/USERmain")
    public String gotoMyPageUS(Model model, Principal principal){
        ReMncsDto reMncsDto = null;
        String email = principal.getName();
        MemberFormDto memberFormDto = memberService.getName(email);

        Member member = memberRepository.findByEmail(email);
        reMncsDto=  conditionService.getMapCondi(member);
        System.out.println("reMncsDto : " + reMncsDto);

        model.addAttribute("memberFormDto", memberFormDto);
        model.addAttribute("myCondi" ,reMncsDto );

        return "admin/USERmyPageMain" ;
    }

    @GetMapping(value = "/LREAmain")
    public String gotoMyPageLR(Model model, Principal principal){
        String email = principal.getName();
        Member member = memberRepository.findByEmail(email);
        MemberFormDto memberFormDto = memberService.getName(email);
        List<MapMainDto> mapMainDtoList = reService.getItemAll(member);

        model.addAttribute("memberFormDto", memberFormDto);
        model.addAttribute("mapMainDtoList", mapMainDtoList);

        return "admin/LREAmyPageMain" ;
    }
}
