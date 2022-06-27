package EZHome.dto;

import EZHome.entity.Content;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ContentFormDto {
    private Long id;

    @NotBlank(message = "제목은 필수 입력 값 입니다.")
    private String title;

    @NotNull(message = "글 내용은 필수 입력 값 입니다.")
    private String main_text;

    @NotNull
    private String category;

    private String tag;

    @NotNull
    private String email;

    //private ContentLikeStatus contentLikeStatus;

    private List<ContentImgDto> contentImgDtoList = new ArrayList<>();

    private List<Long> contentImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public Content createContent(){
        return modelMapper.map(this, Content.class);
    }

    public static ContentFormDto of(Content content){
        return modelMapper.map(content, ContentFormDto.class);
    }
}
