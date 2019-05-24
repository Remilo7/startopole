package com.startopole.services;

import com.startopole.model.entity.Event;

import java.util.List;

public interface EventService {

    public void add(Event event);
    public void edit(Event event);
    public void delete(int eventId);
    public Event getEvent(int eventId);
    public List getAllEvents();
}
