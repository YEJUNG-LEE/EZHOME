package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "mcacs")
@Getter @Setter @ToString
public class Mcacs{

    @Id
    @Column(name="mcacs_id")
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name="mcs_id")
    private Mcs mcs;

    private boolean pub;

    private boolean medic;

    private boolean conv;

    private boolean school;

    private boolean teen;

    private boolean twen;

    private boolean thirty;

    private boolean fourty;

    private boolean fifty;

    private boolean sixty;

    private boolean boulevard;

    private boolean rocket;

    private boolean flat;

    private boolean subway;

    private boolean park;

    private boolean hodi;

}
