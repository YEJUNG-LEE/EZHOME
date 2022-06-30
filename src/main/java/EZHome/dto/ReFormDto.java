package EZHome.dto;

import EZHome.entity.ReCacs;
import EZHome.entity.ReCucs;
import EZHome.entity.ReEs;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ReFormDto {

    private Long id ; // 매물 기본키 (fk)

    @NotNull(message="매물 번호는 필수 입력 값입니다.")
    private Integer reNum;  // 매물 번호



    @NotBlank(message="매물 유형은 필수 입력 값입니다.")
    private String rehouseType ; // 매물 유형

    @NotBlank(message="매매 유형은 필수 입력 값입니다.")
    private String retrType ; // 매매 유형

    @NotNull(message="월세는 필수 입력 값입니다.")
    private Integer reMon_price ; // 월세

    @NotNull(message="관리비는 필수 입력 값입니다.")
    private Integer reAdmn_fee ; // 관리비

    @NotNull(message="보증금는 필수 입력 값입니다.")
    private Integer reDeposit; // 보증금

    @NotNull(message="매매가는 필수 입력 값입니다.")
    private Integer reTrade ; // 매매가

    @NotNull(message="전세는 필수 입력 값입니다.")
    private Integer reJeonse ; // 전세

    @NotBlank(message="'시도' 작성은 필수 입력입니다.")
    private String reSido; // 시도

    @NotBlank(message="'군구' 작성은 필수 입력입니다.")
    private String reGungu; // 군구

    @NotBlank(message="'동' 작성은 필수 입력입니다.")
    private String reDong; // 동

    @NotBlank(message="'상세주소' 작성은 필수 입력입니다.")
    private String reDtl_Adr ; // 상세주소

    @NotNull(message="방개수는 필수 입력입니다.")
    private Integer reRoomcnt ; //방개수

    @NotNull(message="욕실개수는 필수 입력 값입니다.")
    private Integer reBathcnt; // 욕실개수

    @NotNull(message="평수는 필수 입력 값입니다.")
    private Integer reExtent ; // 평수

    @NotNull(message="충수는 필수 입력 값입니다.")
    private Integer reFlr ; // 층수

    @NotNull(message="전체 층수는 필수 입력 값입니다.")
    private Integer reTotalFlr ; // 전체 층수

    private boolean reSecndFlr ; //  복층

    private boolean reTopFlr ; // 옥탑방

    private boolean reUndrflr ; // 반지하

    //매물 맞춤 조건 추가
    private boolean reNew; //신축

    private boolean reFull; //풀옵션

    private boolean reDebt; //대출없음

    private boolean reElvtr; //엘리베이터

    private boolean rePet; //반려동물

    private boolean reScrty; //보안기능

    private boolean reParking; //주차장

    private boolean reSouth; //남향

    private boolean reBug; //벌레퇴치업체

    private boolean reWoman; //여성전용

    private boolean reForest; //숲View

    private boolean reRiver; //리버View

    private boolean reOcean; //오션View

    private boolean reCity; //시티View

    //카테고리 조건 추가
    private boolean rePublic; //공공기관(경찰서, 은행 등)

    private boolean reMedic; //의료시설(병원, 약국)

    private boolean reCnvn; //편의시설(시장, 운동시설, 편의점)

    private boolean reSchol; //학교시설(초등,중등,고등)

    private boolean reTeen; //10대 거주

    private boolean reTwen; //20대 거주

    private boolean reThirty; //30대 거주

    private boolean reFourty; //40대 거주

    private boolean reFifty; //50대 거주

    private boolean reSixty; //60대 이상 거주

    private boolean reMainroad; //대로변

    private boolean reRocket; //로켓배송

    private boolean reFlat; //경사완만

    private boolean reSubway; //역세권

    private boolean rePark; //공원

    private boolean reRsdnt_Area; //주택지구

    //매물에 대한 이미지 정보를 저장하고 있는 List 컬렉션입니다. (최대 10개 이미지)
    private List<ReImgDto> reImgDtoList = new ArrayList<ReImgDto>();

    //상품의 이미지에 대한 id 정보들을 저장하기 위한 List 컬렉션입니다.
    // 상품 수정시 해당 이미지들의 unique id 값을 저장할 리스트 컬렉션입니다.
    private List<Integer> itemImgIds = new ArrayList<Integer>();

    private static ModelMapper modelMapper = new ModelMapper();

    //Dto -> Entity
    public ReEs createReEs(){
        return modelMapper.map(this, ReEs.class);
    }
    public ReCucs createReCucs(){
        return modelMapper.map(this, ReCucs.class);
    }
    public ReCacs createReCacs(){
        return modelMapper.map(this, ReCacs.class);
    }

    // Entity -> Dto
    public static ReFormDto of(ReEs reEs){
        return modelMapper.map(reEs, ReFormDto.class);
    }

}