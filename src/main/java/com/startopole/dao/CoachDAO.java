package com.startopole.dao;

import com.startopole.model.entity.Coach;

import java.util.List;

public interface CoachDAO {

    public void add(Coach coach);
    public void edit(Coach coach);
    public void delete(String username);
    public Coach getCoach(String username);
    public List getAllCoaches();
}
