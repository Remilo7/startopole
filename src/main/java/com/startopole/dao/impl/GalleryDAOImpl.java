package com.startopole.dao.impl;

import com.startopole.dao.GalleryDAO;
import com.startopole.model.entity.Gallery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GalleryDAOImpl implements GalleryDAO {

    @Autowired
    private SessionFactory session;

    public void add(Gallery gallery) {
        session.getCurrentSession().save(gallery);
    }

    public void edit(Gallery gallery) {
        session.getCurrentSession().update(gallery);
    }

    public void delete(int galleryId) {
        session.getCurrentSession().delete(getGallery(galleryId));
    }

    public Gallery getGallery(int galleryId) {
        return session.getCurrentSession().get(Gallery.class, galleryId);
    }

    public List getAllGalleries() {
        return session.getCurrentSession().createQuery("FROM Gallery ORDER BY added_date DESC").list();
    }
}
