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

    private final SeService seService;
    @PostMapping(value = "/service/oto")
//    @RequestMapping(value = "/service/oto", method = {RequestMethod.GET, RequestMethod.POST})
    public String services_oto(@Valid SeFormDto seFormDto, Model model, BindingResult bindingResult,
                               @RequestParam("serviceImgFile")List<MultipartFile> serviceImgFileList, Principal principal){
        if(bindingResult.hasErrors()){
            List<ObjectError> list = bindingResult.getAllErrors();
            for(ObjectError e : list){
                System.out.println(e.getDefaultMessage());
            }
            return "services/SeCe-oto";
        }
        String email = principal.getName();

        try{
            seService.savedSeCe(seFormDto, serviceImgFileList, email);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "문의 둥륵 종 오류가 발생했습니다.");
            e.printStackTrace();
            return "services/SeCe-oto";
        }
        return "redirect:/";
    }
}
