package EZHome.repository;

import EZHome.dto.MapMainDto;
import EZHome.dto.MapSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReEsRepositoryCustom {

    // 메인페이지에서 보여줄 상품 리스트를 구해줍니다.
    Page<MapMainDto> getMainItemPage(MapSearchDto mapSearchDto, Pageable pageable);


}
