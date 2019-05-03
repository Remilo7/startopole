package com.startopole.controller;

import com.startopole.model.entity.Section;
import com.startopole.services.SectionService;
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
public class CoachController {

    @Autowired
    SectionService sectionService;
    private static final String UPLOAD_DIRECTORY ="/resources/uploaded/coaches";

    private Section sectionToEdit;

    @RequestMapping(value = {"/coaches_management"})
    public String coaches_management(Map<String, Object> map){

        Section section = new Section();
        map.put("section", section);
        map.put("sectionList", sectionService.getAllSections("TRENERZY"));
        return "coaches_management";
    }

    @RequestMapping("/editCoach")
    public String editCoach(Map<String, Object> map){

        Section section = new Section();

        section.setHeader(sectionToEdit.getHeader());
        section.setContent(sectionToEdit.getContent());
        section.setId(sectionToEdit.getId());
        section.setSection_name(sectionToEdit.getSection_name());

        map.put("section", section);
        map.put("old_section",sectionToEdit);
        return "editCoach";
    }

    @RequestMapping("/newCoach")
    public String newHistory(Map<String, Object> map){

        Section section = new Section();
        section.setSection_name("TRENERZY");
        map.put("section", section);
        return "newCoach";
    }

    @RequestMapping(value="/coaches.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute Section section, @RequestParam String action, Map<String, Object> map,
                            @RequestParam(required = false) CommonsMultipartFile file, HttpSession session) throws Exception {

        Section sectionResult = new Section();

        if ("add".equals(action.toLowerCase())) {
            section.setSection_name("TRENERZY");
            sectionService.add(section);
            sectionResult = section;

            int fileid = section.getId();

            fileUpload(file, session, fileid);

        } else if ("edit".equals(action.toLowerCase())) {
            section.setSection_name("TRENERZY");
            sectionService.edit(section);
            sectionResult = section;

            if (!file.isEmpty())
                fileUpload(file, session, section.getId());

        } else if ("delete".equals(action.toLowerCase())) {
            sectionService.delete(section.getId());
            sectionResult = new Section();

            ServletContext context = session.getServletContext();

            String filepath = context.getRealPath(UPLOAD_DIRECTORY)+"/img_"+section.getId()+".jpg";

            File temp_file = new File(filepath);
            boolean deleted = temp_file.delete();

        } else if ("back".equals(action.toLowerCase())) {
            return "redirect:/adminPanel";

        } else if ("redirect".equals(action.toLowerCase())) {
            return "redirect:/newCoach";

        } else if ("rededit".equals(action.toLowerCase())) {
            sectionToEdit = sectionService.getSection(section.getId());
            return "redirect:/editCoach";
        }

        map.put("section", sectionResult);
        map.put("sectionList", sectionService.getAllSections("TRENERZY"));
        return "redirect:/coaches_management";
    }

    private void fileUpload(CommonsMultipartFile file, HttpSession session, int fileid) throws Exception {
        try {
            ServletContext context = session.getServletContext();
            String path = context.getRealPath(UPLOAD_DIRECTORY);
            String filename = "img_"+fileid+".jpg";

            System.out.println(path + " " + filename);

            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                    new File(path + File.separator + filename)));
            stream.write(bytes);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not uploaded");
        }
    }
}
