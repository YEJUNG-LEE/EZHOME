package EZHome.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="mcsadd")
@Getter @Setter @ToString
public class Mcsadd {

    @Id
    @GeneratedValue
    @Column(name="mcsadd_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="mcs_id")
    private Mcs mcs;
}
