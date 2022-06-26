package EZHome.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    @GetMapping(value = "/service")
    public String services_freq(Model model){
        return "services/SeCe-freq";
    }

    @GetMapping(value = "/service2")
    public String services_not(Model model){
        return "services/SeCe-not";
    }

    @GetMapping(value = "/service3")
    public String services_oto(Model model){
        return "services/SeCe-oto";
    }
}
