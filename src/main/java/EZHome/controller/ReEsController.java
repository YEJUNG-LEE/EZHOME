package EZHome.controller;

import EZHome.dto.ReFormDto;
import EZHome.service.ReService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReEsController {
//
    // 메물 올리기
    @GetMapping(value="/admin/item/new")
    public String reesInsert(Model model){
        model.addAttribute("ReFormDto", new ReFormDto());
        return "reEs/html/ReItemForm";
    }

    private final ReService reService;
    @PostMapping(value = "/admin/item/new")
    public String itemNew(@Valid ReFormDto reFormDto, BindingResult bindingResult, Model model,
                          @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList, Principal principal){
        System.out.println("aaaaaaa");

        // Dto 유효성검사에 에러가 있는지 체크
        if(bindingResult.hasErrors()){ // 파라미터가 유효성검사에 문제가 있어 에러가 존재하다면
            List<ObjectError> list =  bindingResult.getAllErrors();
            for(ObjectError e : list) {
                System.out.println(e.getDefaultMessage());
            }
            return "reEs/html/ReItemForm" ;  // ReItemForm 으로 이동
        }

        // 이미지 파일 존재하는지 체크
        if(itemImgFileList.get(0).isEmpty() && reFormDto.getId() == null){
            model.addAttribute("errorMessage","첫 번째 이미지는 필수 입력 값입니다.");
            return "reEs/html/ReItemForm" ;
        }

        // principal : (로그인한) 인증된 사용자에 대한 정보를 구할 수 있다.
        String email = principal.getName();

        try {
            reService.savedReEs(reFormDto, itemImgFileList);
        }catch (Exception e){
            model.addAttribute("errorMessage", "상품 등록중에 오류가 발생했습니다.");
            return "reEs/html/ReItemForm" ;
        }


        System.out.println("@@@@@@@@@@@@@@@@@");

        return "reEs/html/InfoDetail"; // 디테일 페이지로

    }

    // 수정 페이지로 진입하기 위한코드
//    @GetMapping("/admin/item/{reImgId}")
//    public String itemDtl(@PathVariable("reImgId") Long reImgId, Model model){
//        return "reEs/html/ReItemForm" ;
//    }


    // 메인 매물 리스트 접근 테스트 중입니다
    @GetMapping(value="/rees")
    public String check(Model model){
        model.addAttribute("ReFormDto", new ReFormDto());
        return "reEs/html/ReEs";
    }


}
