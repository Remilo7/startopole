package com.startopole.services.impl;

import com.startopole.dao.MessageDAO;
import com.startopole.model.entity.Message;
import com.startopole.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDAO messageDAO;

    @Transactional
    public void add(Message message) {
        messageDAO.add(message);
    }

    @Transactional
    public void delete(int messageId) {
        messageDAO.delete(messageId);
    }

    @Transactional
    public Message getMessage(int messageId) {
        return messageDAO.getMessage(messageId);
    }

    @Transactional
    public List getAllMessage() {
        return messageDAO.getAllMessage();
    }

    @Transactional
    public List getAllFencerMessage(String username) {
        return messageDAO.getAllFencerMessage(username);
    }

    @Transactional
    public List getSenderMessages(String username){
        return messageDAO.getSenderMessages(username);
    }
}
