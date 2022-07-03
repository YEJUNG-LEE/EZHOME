package EZHome.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ReMnCsSearchDto {  // map 필터에서 사용될 검색어 DTO 입니다.
    private String searchBy;    // 부동산 및 공인중개사 이름
    private String searchQuery = "";    // 검색 키워드
}
