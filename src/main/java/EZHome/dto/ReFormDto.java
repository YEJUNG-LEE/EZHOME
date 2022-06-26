package EZHome.dto;

import EZHome.entity.ReEs;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class ReFormDto {
    private int reid ; // 매물 기본키 (fk)

    @NotBlank(message="매물 번호는 필수 입력 값입니다.")
    private int reNum;  // 매물 번호

    @NotBlank(message="매물 유형은 필수 입력 값입니다.")
    private String rehouseType ; // 매물 유형

    @NotBlank(message="매매 유형은 필수 입력 값입니다.")
    private String retrType ; // 매매 유형

    @NotBlank(message="월세는 필수 입력 값입니다.")
    private int reMon_price ; // 월세

    @NotBlank(message="관리비는 필수 입력 값입니다.")
    private int reAdmn_fee ; // 관리비

    @NotBlank(message="보증금는 필수 입력 값입니다.")
    private int reDeposit; // 보증금

    @NotBlank(message="매매가는 필수 입력 값입니다.")
    private int reTrade ; // 매매가

    @NotBlank(message="전세는 필수 입력 값입니다.")
    private int reJeonse ; // 전세

    @NotBlank(message="'시도' 작성은 필수 입력입니다.")
    private String reSido; // 시도

    @NotBlank(message="'군구' 작성은 필수 입력입니다.")
    private String reGungu; // 군구

    @NotBlank(message="'동' 작성은 필수 입력입니다.")
    private String reDong; // 동

    @NotBlank(message="'상세주소' 작성은 필수 입력입니다.")
    private String reDtl_Adr ; // 상세주소

    @NotBlank(message="방개수는 필수 입력입니다.")
    private int reRoomcnt ; //방개수

    @NotBlank(message="욕실개수는 필수 입력 값입니다.")
    private int reBathcnt; // 욕실개수

    @NotBlank(message="평수는 필수 입력 값입니다.")
    private int reExtent ; // 평수

    @NotBlank(message="충수는 필수 입력 값입니다.")
    private int reFlr ; // 층수

    @NotBlank(message="전체 층수는 필수 입력 값입니다.")
    private int reTotalFlr ; // 전체 층수


    private boolean reSecndFlr ; //  복층


    private boolean reTopFlr ; // 옥탑방


    private boolean reUndrflr ; // 반지하





    //상품에 대한 이미지 정보를 저장하고 있는 List 컬렉션입니다.

    //상품의 이미지에 대한 id 정보들을 저장하기 위한 List 컬렉션입니다.

    private static ModelMapper modelMapper = new ModelMapper();
    //Dto -> Entity
    public ReEs createReEs(){
        return modelMapper.map(this, ReEs.class);
    }
    // Entity -> Dto
    public static ReFormDto of(ReEs reEs){
        return modelMapper.map(reEs, ReFormDto.class);
    }

}
