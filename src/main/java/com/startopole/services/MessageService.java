package com.startopole.services;

import com.startopole.model.entity.Message;

import java.util.List;

public interface MessageService {

    public void add(Message message);
    public void delete(int messageId);
    public Message getMessage(int messageId);
    public List getAllMessage();
    public List getAllFencerMessage(String username);
    public List getSenderMessages(String username);
}
