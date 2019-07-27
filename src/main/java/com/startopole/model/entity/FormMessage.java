package com.startopole.model.entity;

public class FormMessage {

    private String email;
    private String topic;
    private String content;

    public FormMessage() {
    }

    public FormMessage(String email, String topic, String content) {
        this.email = email;
        this.topic = topic;
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
