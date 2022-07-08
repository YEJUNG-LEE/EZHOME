package EZHome.entity;

import EZHome.dto.SeCeDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "SeCe")
@Getter @Setter
public class SeCe extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "seId")
    private Long id;

    @Column(nullable = true)
    private String seType;  // 문의 유형

    @Column(nullable = true)
    private String seTitle; // 문의 제목

    @Column(nullable = true)
    private String seText;  // 문의 내용

    @ManyToOne
    @JoinColumn(name = "member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    public void updateInquiry(SeCeDto seCeDto){
        this.seType = seType;
        this.seTitle = seTitle;
        this.seText = seText;
    }
}
