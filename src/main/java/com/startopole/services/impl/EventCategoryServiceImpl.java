package com.startopole.services.impl;

import com.startopole.dao.EventCategoryDAO;
import com.startopole.model.entity.EventCategory;
import com.startopole.services.EventCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventCategoryServiceImpl implements EventCategoryService {

    @Autowired
    EventCategoryDAO eventCategoryDAO;

    @Transactional
    public void add(EventCategory eventCategory) {
        eventCategoryDAO.add(eventCategory);
    }

    @Transactional
    public void edit(EventCategory eventCategory) {
        eventCategoryDAO.edit(eventCategory);
    }

    @Transactional
    public void delete(int eventCategoryId) {
        eventCategoryDAO.delete(eventCategoryId);
    }

    @Transactional
    public EventCategory getEvent(int eventCategoryId) {
        return eventCategoryDAO.getEvent(eventCategoryId);
    }

    @Transactional
    public List getEventCategories(String category) {
        return eventCategoryDAO.getEventCategories(category);
    }

    @Transactional
    public List getAllEventCategories() {
        return eventCategoryDAO.getAllEventCategories();
    }

    @Transactional
    public List getOneEventCategories(int eventId){
        return eventCategoryDAO.getOneEventCategories(eventId);
    }
}
