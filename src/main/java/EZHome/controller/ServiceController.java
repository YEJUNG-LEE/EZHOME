// 고객센터 완성
package EZHome.controller;

import EZHome.dto.SeCeDto;
import EZHome.entity.Member;
import EZHome.entity.SeCe;
import EZHome.repository.MemberRepository;
import EZHome.service.SeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    private final SeService seService;
    private final MemberRepository memberRepository;
    @GetMapping(value = "/service/freq")
    public String services_freq(Model model){
        return "services/SeCe-freq";
    }

    @GetMapping(value = "/service/not")
    public String services_not(Model model){
        return "services/SeCe-not";
    }

    @GetMapping(value = "/service/oto")
    public String serviceds_getOto(Model model){
        model.addAttribute("SeCeDto", new SeCeDto());
        return "services/SeCe-oto";
    }

    @PostMapping(value = "/service/oto")
    public String services_otoInsert(Model model, SeCeDto seCeDto, Principal principal){

        System.out.println("********************************");
        System.out.println("*********고객센터 컨트롤러 들어왔습니다.*******");
        System.out.println("********************************");

        if(principal == null){
            return "member/memberLoginForm";
        }


        String email = principal.getName();
        Member member = memberRepository.findByEmail(email);

        System.out.println("********************************");
        System.out.println("*********컨트롤러의 작성한 사람의 아이디를 가져왔습니다.******");
        System.out.println("컨트롤러의 member : " + member);

        try{
            seService.savedSeCe(seCeDto, member);
            System.out.println("db에 고객사항 정보가 저장 되었습니다. 얏호 집에 가세요");
            model.addAttribute("SeCeDto", seCeDto);
        }catch(Exception e){
            model.addAttribute("errorMessage", "문의 등록 중 오류가 발생했습니다.");
            e.printStackTrace();
            return "redirect:/";
        }
        return "services/SeCe-oto";
    }

}
