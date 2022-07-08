package EZHome.dto;

import EZHome.entity.ReImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class ReImgDto {
    private Long id;

//    private String reNm; // 매물이름 ex) 신사역 도보 10분 이내, 투룸
    private String reDscp ; // 매물 상세설명

    private String reImgNm ; ///UUID 형식으로 업로드된 이미지 파일 이름
    private String reOriNm; //이미지 원본 이름
    private String reImgUrl ;
    private String reYN ; // 대표이미지 Y, 나머지 N

    private static ModelMapper modelMapper = new ModelMapper();

    // 상품이미지정보를 이용해서 Entity -> Dto
    public static ReImgDto of(ReImg reImg){
        return modelMapper.map(reImg, ReImgDto.class);
    }

}
