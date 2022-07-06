package EZHome.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SeImg")
@Getter @Setter
public class SeImg extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seImgId")
    private Long id;

    private String seImgName;

    private String seOriNm;

    private String seImgUrl;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private SeCe seCe;

    public void updateServiceImg(String seOriNm, String seImgNm, String seImgUrl) {
        this.seOriNm = seOriNm;
        this.seImgUrl = seImgUrl;
        this.seImgName = seImgNm;
    }


}
