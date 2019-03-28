package com.startopole.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Zawodnik")

public class ZawodnikEntity extends UzytkownikEntity {


    @Column(name = "pesel", nullable = false, unique = true)
    private Integer pesel;

    @Column(name = "birth_date", nullable = false, unique = true)
    private Date birth_date;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "Odbiorcy")
    private Integer id;
}

