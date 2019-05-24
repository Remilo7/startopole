package com.startopole.services.impl;

import com.startopole.dao.EventDAO;
import com.startopole.model.entity.Event;
import com.startopole.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventDAO eventDAO;

    @Transactional
    public void add(Event event) {
        eventDAO.add(event);
    }

    @Transactional
    public void edit(Event event) {
        eventDAO.edit(event);
    }

    @Transactional
    public void delete(int eventId) {
        eventDAO.delete(eventId);
    }

    @Transactional
    public Event getEvent(int eventId) {
        return eventDAO.getEvent(eventId);
    }

    @Transactional
    public List getAllEvents() {
        return eventDAO.getAllEvents();
    }
}
