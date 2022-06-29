package EZHome.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MapController {
    @GetMapping(value="/map")
    public String main(Model model){
        return "reEs/html/ReEs";
    }
}
