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
public class MemberController {

    @Autowired
    SectionService sectionService;

    private Section sectionToEdit;

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public String members(Map<String, Object> map) {

        Section section = new Section();
        map.put("section", section);
        map.put("memberSectionList", sectionService.getAllSections("ZAWODNICY"));

        return "members";
    }

    @RequestMapping(value = {"/members_management"})
    public String members_management(Map<String, Object> map){

        Section section = new Section();
        map.put("section", section);
        map.put("sectionList", sectionService.getAllSections("ZAWODNICY"));
        return "members_management";
    }

    @RequestMapping("/editMember")
    public String editMember(Map<String, Object> map){

        Section section = new Section();

        section.setHeader(sectionToEdit.getHeader());
        section.setContent(sectionToEdit.getContent());
        section.setId(sectionToEdit.getId());
        section.setSection_name(sectionToEdit.getSection_name());

        map.put("section", section);
        map.put("old_section",sectionToEdit);
        return "editMember";
    }

    @RequestMapping("/newMember")
    public String newMember(Map<String, Object> map){

        Section section = new Section();
        section.setSection_name("ZAWODNICY");
        map.put("section", section);
        return "newMember";
    }

    @RequestMapping(value="/members.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute Section section, @RequestParam String action, Map<String, Object> map) {

        Section sectionResult = new Section();

        if ("add".equals(action.toLowerCase())) {
            section.setSection_name("ZAWODNICY");
            sectionService.add(section);
            sectionResult = section;

        } else if ("edit".equals(action.toLowerCase())) {
            section.setSection_name("ZAWODNICY");
            sectionService.edit(section);
            sectionResult = section;

        } else if ("delete".equals(action.toLowerCase())) {
            sectionService.delete(section.getId());
            sectionResult = new Section();

        } else if ("back".equals(action.toLowerCase())) {
            return "redirect:/adminPanel";

        } else if ("redirect".equals(action.toLowerCase())) {
            return "redirect:/newMember";

        } else if ("rededit".equals(action.toLowerCase())) {
            sectionToEdit = sectionService.getSection(section.getId());
            return "redirect:/editMember";
        }

        map.put("section", sectionResult);
        map.put("sectionList", sectionService.getAllSections("ZAWODNICY"));
        return "redirect:/members_management";
    }
}
