package EZHome.dto;

import EZHome.entity.ContentImg;
import org.modelmapper.ModelMapper;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContentImgDto {
    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;
    private static ModelMapper modelMapper = new ModelMapper();

    public static ContentImgDto of(ContentImg contentImg){
        return modelMapper.map(contentImg, ContentImgDto.class);
    }
}
