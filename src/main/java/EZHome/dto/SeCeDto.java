package EZHome.dto;

import EZHome.entity.SeCe;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;

@Getter @Setter @ToString
public class SeCeDto {
    private Long id;

    @NotBlank(message = "문의 유형은 필수 입력 값입니다.")
    private String seType;

    @NotBlank(message = "문의 제목은 필수 입력 값입니다.")
    private String seTitle;

    @NotBlank(message = "문의 내용은 핋수 입력 값입니다.")
    private String seText;

    private static ModelMapper modelMapper = new ModelMapper();

    public SeCe createSeCe(){
        return modelMapper.map(this, SeCe.class);
    }

    public static SeCeDto of(SeCe seCe){
        return modelMapper.map(seCe, SeCeDto.class);
    }
}
