package com.startopole.dao;

import com.startopole.model.entity.Gallery;

import java.util.List;

public interface GalleryDAO {

    public void add(Gallery gallery);
    public void edit(Gallery gallery);
    public void delete(int galleryId);
    public Gallery getGallery(int galleryId);
    public List getAllGalleries();
}
