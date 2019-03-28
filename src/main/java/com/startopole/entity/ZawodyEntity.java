package com.startopole.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Zawody")

public class ZawodyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 10)
    private Long id;


    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "date", nullable = false, unique = true)
    private Date date;

]

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "KategoriaWiekowe")
    private Integer id;
}
