package com.startopole.dao.impl;

import com.startopole.dao.AdminDAO;
import com.startopole.model.entity.Admin;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    private SessionFactory session;

    public void add(Admin admin) {
        session.getCurrentSession().save(admin);
    }

    public void edit(Admin admin) {
        session.getCurrentSession().update(admin);
    }

    public void delete(String username) {
        session.getCurrentSession().delete(getAdmin(username));
    }

    public Admin getAdmin(String username) {
        return session.getCurrentSession().get(Admin.class, username);
    }
}
