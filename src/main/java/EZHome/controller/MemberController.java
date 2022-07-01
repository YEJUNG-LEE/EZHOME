package EZHome.controller;

import EZHome.constant.Role;
import EZHome.dto.MemberFormDto;
import EZHome.entity.Member;
import EZHome.repository.MemberRepository;
import EZHome.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping(value = "/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @ModelAttribute("role")
    public Role[] role() {
        return Role.values();
    }

    @GetMapping(value = "/login")
    public String loginMember(){
        return "member/memberLoginForm" ;
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "이메일 또는 비밀번호를 확인해 주세요.") ;
        return "member/memberLoginForm" ;
    }
//
//    @GetMapping(value = "/error")
//    public String loginError(){
//        return "redirect:/login/error" ;
//    }

    @GetMapping(value = "/new")
    public String memberForm(Model model){

        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }

    private final MemberService memberService ;
    private final PasswordEncoder passwordEncoder ;

    @PostMapping(value = "/login")
    public String login(){
        return "redirect:/" ;
    }

    @PostMapping(value = "/new")
    public String newMember(@Valid MemberFormDto memberFormDto,
                            BindingResult bindingResult,
                            Model model){
        if(bindingResult.hasErrors()){
            return "member/memberForm" ;
        }

        try{
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member) ;
            return "member/memberLoginForm" ;
        }catch (IllegalStateException e){
            return "member/memberForm" ;
        }
    }

    @GetMapping(value = "/update")
    public String update(Model model, Principal principal){
        // 목표 : Member member 객체를 Model.attribute로 넘겨주는거
        // 지금 가지고 있는거 : Principal principal 객체에 getName으로 email값을 가져올 수 있다.
        // 즉, email값으로 Member 객체를 조회해서 가져오면됨.
        String email = principal.getName();
        MemberFormDto memberFormDto = memberService.getName(email);

        model.addAttribute("member", memberFormDto);

        return "member/memberUpdateForm" ;
    }

    @PostMapping(value = "/update/{id}")
    public String updateId(){
        return "member/memberUpdateForm" ;
    }
}
