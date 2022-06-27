package EZHome.controller;

import EZHome.dto.ContentFormDto;
import EZHome.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.xml.ws.Service;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContentController {
    @GetMapping(value = "/content/write")
    public String contentForm(Model model){
        model.addAttribute("contentFormDto", new ContentFormDto());
        return "community/CoMm-wr";
    }

    private ContentService contentService;

    @PostMapping(value = "/content/write")
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

    // 게시글 디테일 파트
//    @GetMapping(value = "CoMm/content/{content_id}")
//    public String conentDtl(@PathVariable("content_id") Long content_Id, Model model){
//        try{
//            ContentFormDto contentFormDto = contentService.getContentDtl(content_Id);
//            model.addAttribute("contentFormDto", contentFormDto);
//        }catch(EntityNotFoundException e){
//            model.addAttribute("errorMessage", "존재하지 않는 게시글입니다.");
//            model.addAttribute("contentFormDto", new ContentFormDto());
//        }
//        return "community/CoMm-detail";
//    }

}
