package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

// 고객센터 1:1문의를 위한 엔터티
@Entity
@Table(name = "service")
@Getter
@Setter
@ToString
public class SeCe {
    @Id
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String type;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name="email")
    private Member member;

}
