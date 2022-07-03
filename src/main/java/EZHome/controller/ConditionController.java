package EZHome.controller;

import EZHome.dto.ReCucsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ConditionController {

    @GetMapping(value = "/user/map")
    public String condiInsert(Model model){
        model.addAttribute("ReCusDto",new ReCucsDto());
        return "reEs/trash/ReEs_CS_CuCa";
    }
}
