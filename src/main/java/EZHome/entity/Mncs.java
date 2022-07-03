package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="mncs")
@Getter @Setter @ToString
public class Mncs { // 기본조건
    @Id
    @GeneratedValue
    @Column(name="mncs_id")
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="mcs_id")
    private Mcs mcs;

    private String housetype;

    private String trType;

    private int minFloor;

    private int maxFloor;

    private boolean halfUnder;

    private boolean loofTop;

    private int minEx;

    private int maxEx;

    private int minMon;

    private int maxMon;

    private int minMan;

    private int maxMan;

    private int minDep;

    private int maxDep;

    private int minTrd;

    private int maxTrd;
}
