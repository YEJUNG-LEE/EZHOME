// 고객센터 완성
package EZHome.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    @GetMapping(value = "/service/freq")
    public String services_freq(Model model){
        return "services/SeCe-freq";
    }

    @GetMapping(value = "/service/not")
    public String services_not(Model model){
        return "services/SeCe-not";
    }


    @GetMapping(value = "service/oto")
    public String services_otoInsert(Model model){
        return "services/SeCe-oto";
    }

}
