package EZHome.entity;

import EZHome.dto.ReFormDto;
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
    private String reSido;  //시/도

    @Column(nullable = false, length = 300)
    private String reGungu; // 군구

    @Column(nullable = false, length = 300)
    private String reDong; // 동

    @Column(nullable = false, length = 300)
    private String reDtl_Adr ; // 상세주소

    @Column(nullable = false)
    private Integer reFlr ; // 층수



    @Column(nullable = false)
    private Integer reTotalFlr ; // 전체 층수


    private boolean reSecndFlr ; //  복층


    private boolean reTopFlr ; // 옥탑방


    private boolean reUndrflr ; // 반지하

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
    private Integer reDeposit; // 보증금

    @Column(nullable = false)
    private Integer reTrade ; // 매매가

    @Column(nullable = false)
    private Integer reJeonse ; // 전세가

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
        this.reJeonse = reFormDto.getReJeonse(); //전세


        this.reSido = reFormDto.getReSido(); //시도
        this.reGungu = reFormDto.getReGungu(); // 군구
        this.reDong = reFormDto.getReDong(); // 동
        this.reDtl_Adr = reFormDto.getReDtl_Adr(); //상세주소

        this.reRoomcnt = reFormDto.getReRoomcnt(); // 방개수
        this.reBathcnt = reFormDto.getReBathcnt(); // 화장실개수
        this.reExtent = reFormDto.getReExtent(); // 평수

        this.reFlr = reFormDto.getReFlr(); // 층수
        this.reTotalFlr = reFormDto.getReTotalFlr(); // 전체층수

        // boolean 타입은 get메소드가 아닌. is메소드로 불러오기가능
//        this.reSecndFlr = reFormDto.isReSecndFlr(); // 복층
//        this.reTopFlr = reFormDto.isReTopFlr(); // 옥탑방
//        this.reUndrflr = reFormDto.isReUndrflr();// 반지하

    }
//
//    public static ReEs createWho(Member member){
//        ReEs reEs = new ReEs();
//        reEs.setMember(member);
//
//        return reEs;
//    }


}