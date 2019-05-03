package com.startopole.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SECTIONS")
public class Section {

    @Id
    private int id;

    @Column
    private String header;

    @Column
    private String content;

    @Column
    private String section_name;

    public Section() {
    }

    public Section(int id, String header, String content, String section_name) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.section_name = section_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }
}
