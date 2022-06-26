package EZHome.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    @GetMapping(value = "/service1")
    public String services_freq(Model model){
        return "service/SeCe-freq";
    }

    @GetMapping(value = "/service2")
    public String services_not(Model model){
        return "service/SeCe-not";
    }

    @GetMapping(value = "/service3")
    public String services_oto(Model model){
        return "service/SeCe-oto";
    }
}
