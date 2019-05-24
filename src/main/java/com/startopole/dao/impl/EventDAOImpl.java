package com.startopole.dao.impl;

import com.startopole.dao.EventDAO;
import com.startopole.model.entity.Event;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDAOImpl implements EventDAO {

    @Autowired
    private SessionFactory session;

    public void add(Event event) {
        session.getCurrentSession().save(event);
    }

    public void edit(Event event) {
        session.getCurrentSession().update(event);
    }

    public void delete(int eventId) {
        session.getCurrentSession().delete(getEvent(eventId));
    }

    public Event getEvent(int eventId) {
        return (Event) session.getCurrentSession().get(Event.class, eventId);
    }

    public List getAllEvents() {
        return session.getCurrentSession().createQuery("FROM Event ORDER BY date DESC").list();
    }
}
