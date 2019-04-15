package com.startopole.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ARTICLE")
public class Article {

    @Id
    private int id;

    @Column
    private String title;

    @Column
    private String content;

    @Column(insertable=false)
    private Timestamp added_date;

    public Article(){}

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Timestamp added_date) {
        this.added_date = added_date;
    }
}
