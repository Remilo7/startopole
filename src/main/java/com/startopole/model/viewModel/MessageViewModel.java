package com.startopole.model.viewModel;

public class MessageViewModel {

    private int id;
    private String sender;
    private String receiver;
    private String category;
    private String content;

    public MessageViewModel() {
    }

    public MessageViewModel(int id, String receiver, String category, String content) {
        this.id = id;
        this.receiver = receiver;
        this.category = category;
        this.content = content;
    }

    public MessageViewModel(String sender, String content) {
        this.sender = sender;
        this.content = content;
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
}
