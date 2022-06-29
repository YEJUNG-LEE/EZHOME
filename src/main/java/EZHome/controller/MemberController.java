package EZHome.controller;

<<<<<<< HEAD

import EZHome.dto.MemberFormDto;
import EZHome.entity.Member;
import EZHome.repository.MemberRepository;
import EZHome.repository.MemberRepository;
import EZHome.Role.Role;
import EZHome.service.MemberService;
=======
import EZHome.constant.Role;
import EZHome.dto.MemberFormDto;
import EZHome.entity.Member;
import EZHome.repository.MemberRepository;
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
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
<<<<<<< HEAD
        return "member/customer/memberLoginForm" ;
=======
        return "member/memberLoginForm" ;
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "이메일 또는 비밀번호를 확인해 주세요.") ;
<<<<<<< HEAD
        return "member/customer/memberLoginForm" ;
    }
=======
        return "member/memberLoginForm" ;
    }
//
//    @GetMapping(value = "/error")
//    public String loginError(){
//        return "redirect:/login/error" ;
//    }
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7

    @GetMapping(value = "/new")
    public String memberForm(Model model){

        model.addAttribute("memberFormDto", new MemberFormDto());
<<<<<<< HEAD
        return "member/customer/memberForm";
=======
        return "member/memberForm";
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
    }

    private final MemberService memberService ;
    private final PasswordEncoder passwordEncoder ;

<<<<<<< HEAD
=======
    @PostMapping(value = "/login")
    public String login(){
        return "redirect:/" ;
    }

>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
    @PostMapping(value = "/new")
    public String newMember(@Valid MemberFormDto memberFormDto,
                            BindingResult bindingResult,
                            Model model){
        if(bindingResult.hasErrors()){
//            System.out.println("요호서안 걸림");
//            System.out.println(memberFormDto.toString());
<<<<<<< HEAD
            return "member/customer/memberForm" ;
=======
            return "member/memberForm" ;
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
        }
//        System.out.println("요호서안 안걸림");

        try{
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member) ;
<<<<<<< HEAD
            return "redirect:/" ; // 메인 페이지로 이동
        }catch (IllegalStateException e){
            return "member/customer/memberForm" ;
=======
            return "member/memberLoginForm" ;
        }catch (IllegalStateException e){
            return "member/memberForm" ;
>>>>>>> 1165e2ed5b4c1ee3c1aab0b8157f5ae81385c2a7
        }
    }
}
