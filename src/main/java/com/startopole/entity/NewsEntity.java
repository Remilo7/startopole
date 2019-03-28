package com.startopole.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "News")

public class NewsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 10)
    private Long id;


    @Column(name = "header", nullable = false)
    private String header;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "date", nullable = false)
    private Date date;


}