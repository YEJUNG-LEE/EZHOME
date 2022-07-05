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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
            System.out.println(member.toString());
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

        model.addAttribute("memberFormDto", memberFormDto);

        return "member/memberUpdateForm" ;
    }

//    @GetMapping(value = "/update")
//    public String update(){
//        return "member/memberUpdateForm" ;
//    }

    @PostMapping(value = "/update/{id}")
    public String updateMember(@Valid MemberFormDto memberFormDto, @PathVariable("id") Long id, Model model){
        try{
            MemberFormDto newMemberFormDto = memberService.updateMember(id, memberFormDto) ;
            model.addAttribute("memberFormDto", memberFormDto);
            System.out.println("memberFormDto : " + memberFormDto.toString());
        }catch (Exception e){
            model.addAttribute("errorMessage", "회원 수정 중에 오류가 발생하였습니다.");

            return "member/memberUpdateForm" ;
        }

        return "redirect:/" ;
    }

    @PostMapping(value = "/delete/{id}")
    public String Delete(@PathVariable("id") String id, HttpServletRequest request){
        int cnt = -999;
        cnt = memberService.Delete(id);

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    @GetMapping(value = "/gogeag")
    public String gogeag(){
        return "services/SeCe-freq" ;
    }
}

