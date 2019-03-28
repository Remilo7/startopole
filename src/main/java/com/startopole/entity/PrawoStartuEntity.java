package com.startopole.entity;

import javax.persistence.*;

@Entity
@Table(name = "PrawoStartu")


public class PrawoStartuEntity {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "Zawody")
    private Integer id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "Zawodnik")
    private Integer id;
}
