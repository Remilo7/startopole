package com.startopole.services;

import com.startopole.model.entity.Coach;

public interface CoachService {

    public void add(Coach coach);
    public void edit(Coach coach);
    public void delete(String username);
    public Coach getCoach(String username);
}
