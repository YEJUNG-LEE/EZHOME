package EZHome.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainContentDto {
    private Long id;
    private String title;   // 글 제목
    private String main_text;   // 글 본문
    private String imgUrl;  // 이미지
    private String tag; // 해시태그
   // private ContentLikeStatus contentLikeStatus;
    private Integer view;   // 조회수
    private String category;    // 글 주제 카테고리

    @QueryProjection
    public MainContentDto(Long id, String title, String main_text, String imgUrl, String tag, String category, Integer view){
        this.id = id;
        this.title = title;
        this.main_text = main_text;
        this.imgUrl = imgUrl;
        this.tag = tag;
       // this.contentLikeStatus = contentLikeStatus;
        this.category = category;
        this.view = view;
    }
}
