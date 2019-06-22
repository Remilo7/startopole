package com.startopole.dao.impl;

import com.startopole.dao.FencerDAO;
import com.startopole.model.entity.Fencer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FencerDAOimpl implements FencerDAO {

    @Autowired
    private SessionFactory session;

    public void add(Fencer fencer) {
        session.getCurrentSession().save(fencer);
    }

    public void edit(Fencer fencer) {
        session.getCurrentSession().update(fencer);
    }

    public void delete(String username) {
        session.getCurrentSession().delete(getFencer(username));
    }

    public Fencer getFencer(String username) {
        return session.getCurrentSession().get(Fencer.class, username);
    }

    public List getAllFencer() {
        return session.getCurrentSession().createQuery("FROM Fencer ORDER BY userName").list();
    }
}
