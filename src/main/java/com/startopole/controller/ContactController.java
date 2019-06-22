package com.startopole.controller;

import com.startopole.model.entity.Section;
import com.startopole.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ContactController {

    @Autowired
    SectionService sectionService;

    private Section sectionToEdit;

    @RequestMapping(value = {"/contact_management"})
    public String trainings_management(Map<String, Object> map){

        Section section = new Section();
        map.put("section", section);
        map.put("sectionList", sectionService.getAllSections("KONTAKT"));
        return "contact_management";
    }

    @RequestMapping("/editContact")
    public String editContact(Map<String, Object> map){

        Section section = new Section();

        section.setHeader(sectionToEdit.getHeader());
        section.setContent(sectionToEdit.getContent());
        section.setId(sectionToEdit.getId());
        section.setSection_name(sectionToEdit.getSection_name());

        map.put("section", section);
        map.put("old_section",sectionToEdit);
        return "editContact";
    }

    @RequestMapping("/newContact")
    public String newContact(Map<String, Object> map){

        Section section = new Section();
        section.setSection_name("KONTAKT");
        map.put("section", section);
        return "newContact";
    }

    @RequestMapping(value="/contact.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute Section section, @RequestParam String action, Map<String, Object> map) {

        Section sectionResult = new Section();

        if ("add".equals(action.toLowerCase())) {
            section.setSection_name("KONTAKT");
            sectionService.add(section);
            sectionResult = section;

        } else if ("edit".equals(action.toLowerCase())) {
            section.setSection_name("KONTAKT");
            sectionService.edit(section);
            sectionResult = section;

        } else if ("delete".equals(action.toLowerCase())) {
            sectionService.delete(section.getId());
            sectionResult = new Section();

        } else if ("back".equals(action.toLowerCase())) {
            return "redirect:/adminPanel";

        } else if ("redirect".equals(action.toLowerCase())) {
            return "redirect:/newContact";

        } else if ("rededit".equals(action.toLowerCase())) {
            sectionToEdit = sectionService.getSection(section.getId());
            return "redirect:/editContact";
        }

        map.put("section", sectionResult);
        map.put("sectionList", sectionService.getAllSections("KONTAKT"));
        return "redirect:/contact_management";
    }
}
