package EZHome.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MapSearchDto { // map에 있는 검색창에 쓰일 dto 입니다.
    private String searchBy;    // 필드 검색 조회 항목
    private String searchQuery; // 검색 키워드
}
