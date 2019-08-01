package com.startopole.dao.impl;

import com.startopole.dao.CoachDAO;
import com.startopole.model.entity.Coach;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoachDAOImpl implements CoachDAO {

    @Autowired
    private SessionFactory session;

    public void add(Coach coach) {
        session.getCurrentSession().save(coach);
    }

    public void edit(Coach coach) {
        session.getCurrentSession().update(coach);
    }

    public void delete(String username) {
        session.getCurrentSession().delete(getCoach(username));
    }

    public Coach getCoach(String username) {
        return session.getCurrentSession().get(Coach.class, username);
    }

    public List getAllCoaches() {
        return session.getCurrentSession().createQuery("FROM Coach").list();
    }
}
