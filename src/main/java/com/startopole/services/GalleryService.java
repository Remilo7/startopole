package com.startopole.services;

import com.startopole.model.entity.Gallery;

import java.util.List;

public interface GalleryService {

    public void add(Gallery gallery);
    public void edit(Gallery gallery);
    public void delete(int galleryId);
    public Gallery getGallery(int galleryId);
    public List getAllGalleries();
}
