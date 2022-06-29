package EZHome.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainTestController {
    @GetMapping(value = "/")
    public String main(Model model){

        return "common/main";
    }

}
