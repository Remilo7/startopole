package com.startopole.entity;

import javax.persistence.*;

@Entity
@Table(name = "Trener")

public class TrenerEntity extends  UzytkownikEntity {

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "Wiadomosc")
    private Integer id;

}
