package com.startopole.dao;

import com.startopole.model.entity.Message;

import java.util.List;

public interface MessageDAO {

    public void add(Message message);
    public void delete(int messageId);
    public Message getMessage(int messageId);
    public List getAllMessage();
    public List getAllFencerMessage(String username);
    public List getSenderMessages(String username);
}
