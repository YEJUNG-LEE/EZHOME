package EZHome.entity;

import EZHome.dto.ReFormDto;
import EZHome.dto.ReMncsDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ReEs") // 매물
@Getter @Setter @ToString
public class ReEs extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="reid")
    private Long id ; // 매물 기본키 (FK)

    @Column(unique = true) // 고유한 매물번호로 매물을 찾습니다.
    private Integer reNum;  // 매물 번호

    @Column(nullable = true, length = 300)
    private String reNm;
    @Column(nullable = false, length = 300)
    private String rehouseType ; // 매물 유형

    @Column(nullable = false, length = 300)
    private String retrType ; // 매매 유형

    @Column(nullable = false, length = 300)

    private String roadAddress; // 시도

    @Column(nullable = false, length = 300)
    private String reDtl_Adr ; // 상세주소

    @Column(nullable = false)
    private Integer reFlr ; // 층수



    @Column(nullable = false)
    private Integer reTotalFlr ; // 전체 층수

    @Column(nullable = false, length = 300)
    private String reFlrType ; // 층수별 유형 (복층, 옥탑방, 반지하)


//    private boolean reSecndFlr ; //  복층
//    private boolean reTopFlr ; // 옥탑방
//    private boolean reUndrflr ; // 반지하

    @Column(nullable = false)
    private Integer reRoomcnt ; //방개수
    @Column(nullable = false)
    private Integer reBathcnt; // 욕실개수
    @Column(nullable = false)
    private Integer reExtent ; // 평수

    @Column(nullable = false)
    private Integer reMon_price ; // 월세

    @Column(nullable = false)
    private Integer reAdmn_fee ; // 관리비

    @Column(nullable = false)
    private Integer reDeposit; // 보증금, 전세가

    @Column(nullable = false)
    private Integer reTrade ; // 매매가

    //회원(일)이 여러개(다)의 매물을 올릴 수 있음으로 '일대다'로 설정했습니다.
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 매물에 대한 정보를 업데이트하는 비즈니스 로직을 구현합니다.
    public void updateItem(ReFormDto reFormDto){
        this.reNum = reFormDto.getReNum(); // 매물번호
        this.rehouseType = reFormDto.getRehouseType(); // 매물유형
        this.retrType=reFormDto.getRetrType(); // 매매유형
        this.reMon_price = reFormDto.getReMon_price(); // 월세
        this.reAdmn_fee = reFormDto.getReAdmn_fee(); // 관리비
        this.reDeposit = reFormDto.getReDeposit(); // 보증금
        this.reTrade = reFormDto.getReTrade(); // 매매가


        this.roadAddress = reFormDto.getRoadAddress(); //시도

        this.reDtl_Adr = reFormDto.getReDtl_Adr(); //상세주소

        this.reRoomcnt = reFormDto.getReRoomcnt(); // 방개수
        this.reBathcnt = reFormDto.getReBathcnt(); // 화장실개수
        this.reExtent = reFormDto.getReExtent(); // 평수

        this.reFlr = reFormDto.getReFlr(); // 층수
        this.reTotalFlr = reFormDto.getReTotalFlr(); // 전체층수
        this.reFlrType = reFormDto.getReFlrType(); //기타 층수

        // boolean 타입은 get메소드가 아닌. is메소드로 불러오기가능
//        this.reSecndFlr = reFormDto.isReSecndFlr(); // 복층
//        this.reTopFlr = reFormDto.isReTopFlr(); // 옥탑방
//        this.reUndrflr = reFormDto.isReUndrflr();// 반지하

    }

    public boolean compare(ReMncsDto reMncsDto) {
        String secndFlr = null;
        String underFlr = null;
        String loofFlr = null;
        if(reMncsDto.isSecondFloor()){secndFlr = "복층";}
        if(reMncsDto.isHalfUnder()){underFlr = "반지하";}
        if(reMncsDto.isLoofTop()){loofFlr = "옥탑방";}
        if(!this.rehouseType.equals(reMncsDto.getHouseType())){return false;}
        if(!this.retrType.equals(reMncsDto.getTrType())){return false;}
        if(!(this.reFlr <= reMncsDto.getMinFloor() && this.reFlr >= reMncsDto.getMaxFloor())){return false;}
        if(!(this.reFlrType.equals(secndFlr) || this.reFlrType.equals(underFlr) || this.reFlrType.equals(loofFlr))){return false;}
        if(!(this.reExtent <= reMncsDto.getMinEx() && this.reExtent >= reMncsDto.getMaxEx())){return false;}
        if(!(this.reMon_price <= reMncsDto.getMinMon() && this.reMon_price >= reMncsDto.getMaxMon())){return false;}
        if(!(this.reDeposit <= reMncsDto.getMinDep() && this.reDeposit >= reMncsDto.getMaxDep())){return false;}

//        if(!(this.reTrade <= reMncsDto.getMinMon() && this.reTrade >= reMncsDto.getMax())){return false;}

//        if(!this.roadAddress.equals(reMncsDto.getHouseType())){return false;}
        return true;
    }
//
//    public static ReEs createWho(Member member){
//        ReEs reEs = new ReEs();
//        reEs.setMember(member);
//
//        return reEs;
//    }


}