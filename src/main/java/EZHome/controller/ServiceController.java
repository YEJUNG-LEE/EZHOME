// 고객센터 완성
package EZHome.controller;

import EZHome.dto.SeFormDto;
import EZHome.service.SeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

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
        model.addAttribute("seFormDto", new SeFormDto());
        return "services/SeCe-oto";
    }

}
