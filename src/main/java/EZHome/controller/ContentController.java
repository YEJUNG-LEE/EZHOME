package EZHome.controller;

import EZHome.dto.ContentFormDto;
import EZHome.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContentController {
    @GetMapping(value = "/ezhome/Content/Write")
    public String contentForm(Model model){
        model.addAttribute("contentFormDto", new ContentFormDto());
        return "community/CoMm-wr";
    }

    private ContentService contentService;

    @PostMapping(value = "/ezhome/Content/Write")
    public String contentNew(@Valid ContentFormDto contentFormDto, BindingResult bindingResult, Model model,
                             @RequestParam("contentImgFile")List<MultipartFile> contentImgFileList){
        if(bindingResult.hasErrors()){
            return "community/CoMm-wr";
        }
        try{
            contentService.saveContent(contentFormDto, contentImgFileList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "게시글 등록 중 오류가 발생했습니다.");
            return "community/CoMm-wr";
        }
        return "redirect:/";
    }

}
