package com.startopole.entity;

import javax.persistence.*;

@Entity
@Table(name = "KategorieWiekowe")


public class KategorieWiekoweEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 10)
    private Long id;


    @Column(name = "name", nullable = false, unique = true)
    private String name;


}
