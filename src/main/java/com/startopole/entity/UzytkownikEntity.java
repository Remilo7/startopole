package com.startopole.entity;


import javax.persistence.*;

@Entity
@Table(name = "Uzytkownik")

public class UzytkownikEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 10)
    private Long id;


    @Column(name = "email", nullable = false, unique = true)
    private Integer email;

    @Column(name = "password", nullable = false, unique = false)
    private String password;

    @Column(name = "surname", nullable = false, unique = false)
    private String surname;

    @Column(name = "name", nullable = false, unique = false)
    private String name;



}