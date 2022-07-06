package EZHome.dto;

import EZHome.entity.SeCe;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class SeFormDto {
    private Long id;    // 문의 id

    @NotNull(message="문의 유형은 필수 입력 값입니다.")
    private String type;    // 문의 유형

    @NotNull(message="문의 제목은 필수 입력 값입니다.")
    private String title;   // 문의 제목

    @NotNull(message="문의 내용은 필수 입력 값입니다.")
    private String content; // 문의 내용

    private static ModelMapper modelMapper = new ModelMapper();

    public SeCe createSeCe(){
        return modelMapper.map(this, SeCe.class);
    }

}
