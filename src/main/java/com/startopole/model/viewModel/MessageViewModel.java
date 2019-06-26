package com.startopole.model.viewModel;

import java.sql.Time;
import java.sql.Timestamp;

public class MessageViewModel {

    private int id;
    private String sender;
    private String receiver;
    private String category;
    private String content;
    private Timestamp added_date;

    public MessageViewModel() {
    }

    public MessageViewModel(int id, String receiver, String category, String content, Timestamp added_date) {
        this.id = id;
        this.receiver = receiver;
        this.category = category;
        this.content = content;
        this.added_date = added_date;
    }

    public MessageViewModel(String sender, String content, Timestamp added_date) {
        this.sender = sender;
        this.content = content;
        this.added_date = added_date;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Timestamp getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Timestamp added_date) {
        this.added_date = added_date;
    }
}
