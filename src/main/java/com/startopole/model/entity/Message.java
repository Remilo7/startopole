package com.startopole.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MESSAGES")
public class Message {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "sender")
    private UserInfo sender;

    @ManyToOne
    @JoinColumn(name = "receiver")
    private UserInfo receiver;

    @Column
    private String category;

    @Column
    private String content;

    @Column(insertable=false)
    private Timestamp added_date;

    public Message() {
    }

    public Message(UserInfo sender, UserInfo receiver, String category, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.category = category;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo getSender() {
        return sender;
    }

    public void setSender(UserInfo sender) {
        this.sender = sender;
    }

    public UserInfo getReceiver() {
        return receiver;
    }

    public void setReceiver(UserInfo receiver) {
        this.receiver = receiver;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
