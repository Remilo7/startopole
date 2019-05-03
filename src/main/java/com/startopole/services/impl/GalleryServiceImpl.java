package com.startopole.services.impl;

import com.startopole.dao.GalleryDAO;
import com.startopole.model.entity.Gallery;
import com.startopole.services.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    GalleryDAO galleryDAO;

    @Transactional
    public void add(Gallery gallery) {
        galleryDAO.add(gallery);
    }

    @Transactional
    public void edit(Gallery gallery) {
        galleryDAO.edit(gallery);
    }

    @Transactional
    public void delete(int galleryId) {
        galleryDAO.delete(galleryId);
    }

    @Transactional
    public Gallery getGallery(int galleryId) {
        return galleryDAO.getGallery(galleryId);
    }

    @Transactional
    public List getAllGalleries() {
        return galleryDAO.getAllGalleries();
    }
}
