package com.shopping.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="New_Person")
@Getter @Setter @ToString
public class NewPerson {
    @Id
    @Column(name="NewPerson_id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Integer salary;
}
