package EZHome.dto;

import EZHome.entity.SeImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class SeImgDto {
    private Long id;

    private String seImgNm;

    private String seOriNm;

    private String seImgUrl;

    private static ModelMapper modelMapper = new ModelMapper();

    public static SeImgDto of(SeImg seImg){
        return modelMapper.map(seImg, SeImgDto.class);
    }
}
