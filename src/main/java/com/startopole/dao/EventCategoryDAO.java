package com.startopole.dao;

import com.startopole.model.entity.EventCategory;

import java.util.List;

public interface EventCategoryDAO {

    public void add(EventCategory eventCategory);
    public void edit(EventCategory eventCategory);
    public void delete(int eventCategoryId);
    public EventCategory getEvent(int eventCategoryId);
    public List getEventCategories(String category);
    public List getAllEventCategories();
    public List getOneEventCategories(int eventId);
}
