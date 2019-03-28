package com.startopole.entity;

import javax.persistence.*;

@Entity
@Table(name = "Notatka")

public class NotatkaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 10)
    private Long id;


    @Column(name = "content", nullable = false)
    private Integer content;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "Zawody")
    private Integer id;
}
