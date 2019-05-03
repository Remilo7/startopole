package com.startopole.dao;

import com.startopole.model.entity.Section;

import java.util.List;

public interface SectionDAO {

    public void add(Section section);
    public void edit(Section section);
    public void delete(int sectionId);
    public Section getSection(int sectionId);
    public List getAllSections(String section_name);
}
