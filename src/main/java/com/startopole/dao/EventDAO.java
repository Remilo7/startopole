package com.startopole.dao;

import com.startopole.model.entity.Event;

import java.util.List;

public interface EventDAO {

    public void add(Event event);
    public void edit(Event event);
    public void delete(int eventId);
    public Event getEvent(int eventId);
    public List getAllEvents();
}
