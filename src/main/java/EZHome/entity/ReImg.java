package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ReImg")
@Getter @Setter @ToString
public class ReImg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reImgId;

    private String reImgNm; //UUID 형식으로 업로드된 이미지 파일 이름
    private String reOriNm; //이미지 원본 이름
    private int reImgUrl ;
    private String reYN ; // 대표이미지 Y, 나머지 N

    @Column(nullable = false, length = 300)
    private String reDscp ; // 매물 상세설명

    // 하나의 매물(1)에 여러개(n)의 이미지를 올릴 수 있음으로 '일대다'로 설정했습니다.
    @ManyToOne
    @JoinColumn(name = "reid")
    private ReEs reEs;
}
