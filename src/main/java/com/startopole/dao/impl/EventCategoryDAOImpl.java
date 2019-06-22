package com.startopole.dao.impl;

import com.startopole.dao.EventCategoryDAO;
import com.startopole.model.entity.EventCategory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventCategoryDAOImpl implements EventCategoryDAO {

    @Autowired
    private SessionFactory session;

    public void add(EventCategory eventCategory) {
        session.getCurrentSession().save(eventCategory);
    }

    public void edit(EventCategory eventCategory) {
        session.getCurrentSession().update(eventCategory);
    }

    public void delete(int eventCategoryId) {
        session.getCurrentSession().delete(getEvent(eventCategoryId));
    }

    public EventCategory getEvent(int eventCategoryId) {
        return (EventCategory) session.getCurrentSession().get(EventCategory.class, eventCategoryId);
    }

    public List getEventCategories(String category) {

        String sql = "FROM EventCategory  WHERE category_id.name=LOWER('"+category+"')";

        return session.getCurrentSession().createQuery(sql).list();
    }

    public List getAllEventCategories() {
        return session.getCurrentSession().createQuery("FROM EventCategory").list();
    }

    public List getOneEventCategories(int eventId){
        String sql = "FROM EventCategory WHERE event_id='"+eventId+"'";
        return session.getCurrentSession().createQuery(sql).list();
    }
}
