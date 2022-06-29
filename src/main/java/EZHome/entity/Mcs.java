package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

// 회원의 조건정보를 기록하는 테이블입니다.
@Entity
@Table(name="mCs")
@Getter @Setter @ToString
public class Mcs {
    @Id
    @Column(name="mcs_id")
    @GeneratedValue
    private Long id;

    // member Id 참조
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="member_id")
//    private Member member;

}
