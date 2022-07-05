package EZHome.controller;

import EZHome.constant.Role;
import EZHome.service.MemberService;
import EZHome.service.ReService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

}
