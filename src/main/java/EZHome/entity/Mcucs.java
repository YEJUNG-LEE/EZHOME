package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="mcucs")
@Getter @Setter @ToString
public class Mcucs {
    @Id
    @Column(name="mcucs_id")
    @GeneratedValue
    private Long id;


    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="mcs_id")
    private Mcs mcs;

    private boolean newHouse;

    private boolean full;

    private boolean debt;

    private boolean elevator;

    private boolean pet;

    private boolean security;

    private boolean parking;

    private boolean south;

    private boolean bug;

    private boolean woman;

    private boolean forest;

    private boolean river;

    private boolean ocean;

    private boolean city;
}
