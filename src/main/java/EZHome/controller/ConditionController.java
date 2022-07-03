package EZHome.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ConditionController {

    @GetMapping(value = "/user/map")
    public String condiInsert(Model model){
        return "reEs/trash/ReES_CS";
    }
}
