package com.startopole.services.impl;

import com.startopole.dao.SectionDAO;
import com.startopole.model.entity.Section;
import com.startopole.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDAO sectionDAO;

    @Transactional
    public void add(Section section) {
        sectionDAO.add(section);
    }

    @Transactional
    public void edit(Section section) {
        sectionDAO.edit(section);
    }

    @Transactional
    public void delete(int sectionId) {
        sectionDAO.delete(sectionId);
    }

    @Transactional
    public Section getSection(int sectionId) {
        return sectionDAO.getSection(sectionId);
    }

    @Transactional
    public List getAllSections(String section_name) {
        return sectionDAO.getAllSections(section_name);
    }
}
