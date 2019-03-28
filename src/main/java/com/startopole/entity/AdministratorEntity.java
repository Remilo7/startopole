package com.startopole.entity;

import javax.persistence.*;

@Entity
@Table(name = "Administrator")


public class AdministratorEntity extends UzytkownikEntity {

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "Wiadomosc")
    private Integer id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "News")
    private Integer id;

}
