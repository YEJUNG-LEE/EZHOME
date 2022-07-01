package EZHome.controller;

import EZHome.dto.MapMainDto;
import EZHome.dto.MapSearchDto;
import EZHome.dto.ReFormDto;
import EZHome.entity.Member;
import EZHome.service.MemberService;
import EZHome.service.ReService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MapController {

    private final ReService reService;
//    @GetMapping(value="/map")
//    public String main(MapSearchDto mapSearchDto, Optional<Integer> page, Model model){
//
//        Pageable pageable = PageRequest.of(page.isPresent() ? page.get(): 0, 11);
//
////        if(mapSearchDto.getSearchQuery() != null){
////            if(mapSearchDto.getSearchQuery().equals("null")) {
////                mapSearchDto.setSearchQuery(null);
////            }
////        }
//
//        Page<MapMainDto> items = reService.getMainItemPage(mapSearchDto, pageable);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
//        System.out.println(items.getSize());
//        model.addAttribute("items", items);
//        model.addAttribute("mapSearchDto", mapSearchDto);
//        model.addAttribute("maxPage", 5);
//
//        return "reEs/html/ReEs";
//    }

    @GetMapping(value="/map")
    public String main(Model model){
        try{
            List<MapMainDto> mapMainDtoList = reService.getItemAll(); //id로 기존에 상품 정보를 formdto에 담기
            for (MapMainDto mapMainDto: mapMainDtoList) {
                System.out.println("reFormDto : " + mapMainDto.toString());
                System.out.println("lreaName : " + mapMainDto.getLreaName());
                System.out.println("lreaNick : " + mapMainDto.getLreaNick());
                System.out.println("src : " + mapMainDto.getReImgUrl());
            }
            model.addAttribute("mapMainDtoList", mapMainDtoList); //기존에 등록했던 내용이담긴
        }catch(EntityNotFoundException e){
            model.addAttribute("errorMessage", "존재하지 않는 상품입니다.");
        }
        System.out.println("잘돼요~!");
        return "reEs/html/ReEs";
    }


    // 메인 화면에서 상품이미지를 클릭하면 상품 상세페이지로 이동합니다.
    @GetMapping(value="/map/{id}")
    public String gotoDtl(@PathVariable("id") Long DtlId, Model model ){
        ReFormDto reFormDto = reService.getItemDtl(DtlId);
        Member member = reService.getLrea(DtlId);
        model.addAttribute("DtlItem", reFormDto);
        model.addAttribute("member", member);
        return "reEs/html/InfoDetail";
    }
}
