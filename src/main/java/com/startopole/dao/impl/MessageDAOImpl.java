package com.startopole.dao.impl;

import com.startopole.dao.MessageDAO;
import com.startopole.model.entity.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @Autowired
    private SessionFactory session;

    public void add(Message message) {
        session.getCurrentSession().save(message);
    }

    public void delete(int messageId) {
        session.getCurrentSession().delete(getMessage(messageId));
    }

    public Message getMessage(int messageId) {
        return (Message)session.getCurrentSession().get(Message.class, messageId);
    }

    public List getAllMessage() {
        return session.getCurrentSession().createQuery("FROM Message ORDER BY id DESC").list();
    }

    public List getAllFencerMessage(String username) {
        String sql = "FROM Message  WHERE receiver.userName='"+username+"' ORDER BY id DESC";

        return session.getCurrentSession().createQuery(sql).list();
    }

    public List getSenderMessages(String username) {
        String sql = "FROM Message  WHERE sender.userName='"+username+"' ORDER BY id DESC";

        return session.getCurrentSession().createQuery(sql).list();
    }
}
