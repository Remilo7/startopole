package com.startopole.controller;

import com.startopole.model.entity.Gallery;
import com.startopole.services.GalleryService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

@Controller
public class GalleryController {

    @Autowired
    GalleryService galleryService;

    private Gallery galleryToEdit;
    private static final String UPLOAD_DIRECTORY ="/resources/uploaded/galleries";

    @RequestMapping(value = {"/galleries_management"})
    public String galleries_management(Map<String, Object> map){

        Gallery gallery = new Gallery();
        gallery.setId(((Gallery)(galleryService.getAllGalleries().get(0))).getId());
        map.put("gallery", gallery);
        map.put("galleryList", galleryService.getAllGalleries());
        return "galleries_management";
    }

    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public String album(Map<String, Object> map, @RequestParam("galleryId") int galleryId){

        Gallery gallery = galleryService.getGallery(galleryId);
        map.put("gallery", gallery);
        return "album";
    }

    @RequestMapping("/editGallery")
    public String editGallery(Map<String, Object> map){

        Gallery gallery = new Gallery();
        gallery.setName(galleryToEdit.getName());
        gallery.setId(galleryToEdit.getId());
        gallery.setAdded_date(galleryToEdit.getAdded_date());

        map.put("gallery", gallery);
        map.put("old_gallery",galleryToEdit);
        return "editGallery";
    }

    @RequestMapping("/newGallery")
    public String newGallery(Map<String, Object> map){

        Gallery gallery = new Gallery();
        map.put("gallery", gallery);
        return "newGallery";
    }

    @RequestMapping("/galleries")
    public String galleries(Map<String, Object> map){

        Gallery gallery = new Gallery();
        map.put("gallery", gallery);
        map.put("galleryList", galleryService.getAllGalleries());
        return "galleries";
    }

    @RequestMapping(value="/gallery.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute Gallery gallery, @RequestParam String action, Map<String, Object> map,
                            @RequestParam(required = false) CommonsMultipartFile [] files, HttpSession session) throws Exception {

        Gallery galleryResult = new Gallery();

        if ("add".equals(action.toLowerCase())) {
            map.put("files",files);
            gallery.setAmount(files.length);
            galleryService.add(gallery);
            galleryResult = gallery;

            int fileid = ((Gallery)(galleryService.getAllGalleries().get(0))).getId();

            fileUpload(files, session, fileid);

        } else if ("edit".equals(action.toLowerCase())) {
            map.put("files",files);
            gallery.setAmount(files.length);
            galleryService.edit(gallery);
            galleryResult = gallery;

            int fileid = ((Gallery)(galleryService.getAllGalleries().get(0))).getId();
            fileUpload(files, session, fileid);

        } else if ("delete".equals(action.toLowerCase())) {
            galleryService.delete(gallery.getId());
            galleryResult = new Gallery();

            ServletContext context = session.getServletContext();
            String path = context.getRealPath(UPLOAD_DIRECTORY);
            path = path+"/gallery"+gallery.getId();

            FileUtils.deleteDirectory(new File(path));

        } else if ("back".equals(action.toLowerCase())) {
            return "redirect:/adminPanel";

        } else if ("redirect".equals(action.toLowerCase())) {
            return "redirect:/newGallery";

        } else if ("rededit".equals(action.toLowerCase())) {
            galleryToEdit = galleryService.getGallery(gallery.getId());
            return "redirect:/editGallery";

        }

        map.put("article", galleryResult);
        map.put("articleList", galleryService.getAllGalleries());
        return "redirect:/galleries_management";
    }

    private void fileUpload(CommonsMultipartFile [] files, HttpSession session, int fileid) throws Exception {
        try {
            ServletContext context = session.getServletContext();
            String path = context.getRealPath(UPLOAD_DIRECTORY);

            path = path+"/gallery"+fileid;
            new File(path).mkdirs();

            for (int i=0; i<files.length; i++) {

                String filename = "img_"+i+".jpg";

                System.out.println(path + " " + filename);

                byte[] bytes = files[i].getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                        new File(path + File.separator + filename)));
                stream.write(bytes);
                stream.flush();
                stream.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not uploaded");
        }
    }
}
