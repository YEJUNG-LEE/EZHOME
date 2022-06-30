package EZHome.controller;

import EZHome.dto.MapMainDto;
import EZHome.dto.MapSearchDto;
import EZHome.dto.ReFormDto;
import EZHome.service.ReService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MapController {

    private final ReService reService;
    @GetMapping(value="/map")
    public String main(MapSearchDto mapSearchDto, Optional<Integer> page, Model model){

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get(): 0, 11);

        if(mapSearchDto.getSearchQuery() != null){
            if(mapSearchDto.getSearchQuery().equals("null")) {
                mapSearchDto.setSearchQuery(null);
            }
        }

        Page<MapMainDto> items = reService.getMainItemPage(mapSearchDto, pageable);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(items.getSize());
        model.addAttribute("items", items);
        model.addAttribute("mapSearchDto", mapSearchDto);
        model.addAttribute("maxPage", 5);

        return "reEs/html/ReEs";
    }

    // 메인 화면에서 상품이미지를 클릭하면 상품 상세페이지로 이동합니다.
    @GetMapping(value="/map/{id}")
    public String gotoDtl(@PathVariable("id") Long DtlId, Model model ){
        ReFormDto reFormDto = reService.getItemDtl(DtlId);
        model.addAttribute("DtlItem", reFormDto);
        return "reEs/html/InfoDetail";
    }

}
