package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="ReCacs") // 카테고리 매물
@Getter @Setter @ToString
public class ReCacs extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long caid ; // 매물 카테고리 기본키(Fk)

    private boolean rePublic ; //공공기관(경찰서, 은행 등)
    private boolean reMedic ; //의료시설(병원, 약국)
    private boolean reCnvn; // 편의시설(시장, 편의점, 운동시설)
    private boolean reSchol ; // 학교(초등, 중등, 고등)
    private boolean reTeen ; // 10대 거주
    private boolean reTwen ; // 20대 거주
    private boolean reThirty; // 30대 거주
    private boolean reFourty; // 40대 거주
    private boolean reFifty; // 50대 거주
    private boolean reSixty; // 60대 거주
    private boolean reMainroad; // 대로변
    private boolean reRocket ; // 로캣배송
    private boolean reFlat ; // 경사완만
    private boolean reSubway ; // 역세권
    private boolean rePark; // 공원
    private boolean reRsdnt_Area ; // 주택가

    //회원(일)이 여러개(다)의 매물카테고리조건을 올릴 수 있음으로 '일대다'로 설정했습니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
