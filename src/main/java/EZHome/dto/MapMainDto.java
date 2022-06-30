package EZHome.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter @Setter
public class MapMainDto {
    private Long id; //매물 id

    private String retrType ; // 매매 유형


    private Integer reDeposit; // 보증금
    private Integer reMon_price ; // 월세
    private Integer reAdmn_fee ; // 관리비

    private Integer reFlr ; // 층수
    private Integer reExtent ; // 평수


    private String reSido; // 시도
    private String reGungu; // 군구
    private String reDong; // 동
    private String reDtl_Adr ; // 상세주소

    private String lreaName;    // 공인중개사 이름

    private String lreaNick;    // 공인중개사 닉네임

    private String reImgUrl ;// 이미지 url


//    @QueryProjection
//    public MapMainDto(Long id, String retrType, Integer reDeposit, Integer reMon_price, Integer reAdmn_fee, Integer reFlr , Integer reExtent,
//                         String reSido,String reGungu, String reDong, String reDtl_Adr,  String reImgUrl ){
//        this.id = id;
//        this.retrType = retrType;
//        this.reDeposit = reDeposit;
//        this.reMon_price = reMon_price;
//        this.reAdmn_fee = reAdmn_fee;
//        this.reFlr = reFlr;
//        this.reExtent = reExtent;
//        this.reSido = reSido;
//        this.reGungu = reGungu;
//        this.reDong = reDong;
//        this.reDtl_Adr = reDtl_Adr;
////        this.Memb_nick = Memb_nick;
////        this.Memb_name = Memb_name;
//        this.reImgUrl = reImgUrl;
//
//    }
}
