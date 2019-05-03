package com.startopole.dao.impl;

import com.startopole.dao.SectionDAO;
import com.startopole.model.entity.Section;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SectionDAOImpl implements SectionDAO {

    @Autowired
    private SessionFactory session;

    public void add(Section section) {
        session.getCurrentSession().save(section);
    }

    public void edit(Section section) {
        session.getCurrentSession().update(section);
    }

    public void delete(int sectionId) {
        session.getCurrentSession().delete(getSection(sectionId));
    }

    public Section getSection(int sectionId) {
        return session.getCurrentSession().get(Section.class, sectionId);
    }

    public List getAllSections(String section) {
        String sql = "FROM Section WHERE section_name='"+section+"'";
        return session.getCurrentSession().createQuery(sql).list();
    }
}
