 package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

 @Entity
@Table(name="ReCucs") // 커스텀 매물
@Getter @Setter @ToString
public class ReCucs extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cuid")
    private Long id ; //매물 맞춤 기본키(FK)



    private boolean reNew ; // 신축
    private boolean reFull ; // 풀옵션
    private boolean reDebt ; // 대출유무
    private boolean reElvtr ; // 엘리베이터
    private boolean rePet ; //  발련동물
    private boolean reScrty ; // 보안기능
    private boolean reParking ; // 주차장
    private boolean reSouth ; // 남향
    private boolean reBug; // 벌레 퇴치 업체
    private boolean reWoman; // 여성전용
    private boolean reForest ; // 숲 view
    private boolean reRiver ; // 강 vide ;
    private boolean reOcean ; // 오션 view
    private boolean reCity ; // 도시 view

    @OneToOne()
    @JoinColumn(name = "reid")
     private ReEs reEs;
}
