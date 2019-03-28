package com.startopole.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Wiadomosc")


public class WiadomoscEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 10)
    private Long id;


    @Column(name = "email", nullable = false)
    private Integer email;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "date", nullable = false )
    private Date date;

    @Column(name = "category", nullable = false)
    private String category;
}
