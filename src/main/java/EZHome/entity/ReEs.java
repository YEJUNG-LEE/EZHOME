package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="ReEs") // 매물
@Getter @Setter @ToString
public class ReEs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int reid ; // 매물 기본키 (FK)

    @Column(unique = true) // 고유한 매물번호로 매물을 찾습니다.
    private int reNum;  // 매물 번호

    @Column(nullable = false, length = 300)
    private String reNm; // 매물이름 ex) 신사역 도보 10분 이내, 투룸

    @Column(nullable = false, length = 300)
    private String rehouseType ; // 매물 유형

    @Column(nullable = false, length = 300)
    private String retrType ; // 매매 유형

    @Column(nullable = false, length = 300)
    private String reSido; // 시도

    @Column(nullable = false, length = 300)
    private String reGungu; // 군구

    @Column(nullable = false, length = 300)
    private String reDong; // 동

    @Column(nullable = false, length = 300)
    private String reDtl_Adr ; // 상세주소

    @Column(nullable = false)
    private int reFlr ; // 층수

    /* 전체층수부터 평수는 빠른 구현을 위해 'null 값 허용' 으로 설정하겠습니다.*/
    private int reTotalFlr ; // 전체 층수
    private boolean reSecndFlr ; //  복층
    private boolean reTopFlr ; // 옥탑방
    private boolean reUndrflr ; // 반지하
    private int reRoomcnt ; //방개수
    private int reBathcnt; // 욕실개수
    private int reExtent ; // 평수

    @Column(nullable = false)
    private int reMon_price ; // 월세

    @Column(nullable = false)
    private int reAdmn_fee ; // 관리비

    @Column(nullable = false)
    private int reDeposit; // 보증금

    @Column(nullable = false)
    private int reTrade ; // 매매가

    //회원(일)이 여러개(다)의 매물을 올릴 수 있음으로 '일대다'로 설정했습니다.
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    // 매물에 대한 정보를 업데이트하는 비즈니스 로직을 구현합니다.

}
