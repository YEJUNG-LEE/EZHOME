package EZHome.dto;

import EZHome.entity.Member;
import EZHome.entity.ReEs;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class MapMainDto {
    private Long id; //매물 id
    private Long reNum; // 매물 번호
    private String retrType ; // 매매 유형


    private Integer reDeposit; // 보증금
    private Integer reMon_price ; // 월세
    private Integer reAdmn_fee ; // 관리비
    private Integer reTrade; // 매매가

    private Integer reFlr ; // 층수
    private Integer reExtent ; // 평수

    private String roadAddress; // 도로명주소

    private String reDtl_Adr ; // 상세주소

    private String lreaName;    // 공인중개사 이름

    private String lreaNick;    // 공인중개사 닉네임

    private String reImgUrl ;// 이미지 url

    private Integer select ; // 몇 개를 선택했는지
    private Integer correct ; // 몇 개가 맞았는지
    private Integer percent ; // 몇 퍼센트 일치인지
    private Integer rank; // 순위가 몇 번인지

    // 회원 주소와 매물 주소가 일치한 매물만 담을 List
    List<MapMainDto> memberReESList = new ArrayList<MapMainDto>();

    private static ModelMapper modelMapper = new ModelMapper();

    public static MapMainDto of(ReEs reEs) {
            return modelMapper.map(reEs, MapMainDto.class);
    }
    public static MapMainDto memof(Member member) {
        return modelMapper.map(member, MapMainDto.class);
    }

    public MapMainDto(){}

    @QueryProjection
    public MapMainDto(Long id, String retrType, Integer reDeposit, Integer reMon_price, Integer reAdmn_fee, Integer reFlr , Integer reExtent,
                         String roadAddress, String reDtl_Adr,  String reImgUrl ){
        this.id = id;
        this.retrType = retrType;
        this.reDeposit = reDeposit;
        this.reMon_price = reMon_price;
        this.reAdmn_fee = reAdmn_fee;
        this.reFlr = reFlr;
        this.reExtent = reExtent;
        this.roadAddress = roadAddress;
        this.reDtl_Adr = reDtl_Adr;
//        this.Memb_nick = Memb_nick;
//        this.Memb_name = Memb_name;
        this.reImgUrl = reImgUrl;

    }
}
