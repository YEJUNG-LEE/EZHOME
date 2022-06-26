package EZHome.controller;

import EZHome.dto.ReFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ReEsController {

    // 메물 올리기
    @GetMapping(value="/admin/item/new")
    public String reesInsert(Model model){
        model.addAttribute("ReFormDto", new ReFormDto());
        return "ReItem/HelloTest";
    }


}
