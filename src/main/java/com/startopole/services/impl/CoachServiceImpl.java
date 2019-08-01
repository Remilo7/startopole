package com.startopole.services.impl;

import com.startopole.dao.CoachDAO;
import com.startopole.model.entity.Coach;
import com.startopole.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    CoachDAO coachDAO;

    @Transactional
    public void add(Coach coach) {
        coachDAO.add(coach);
    }

    @Transactional
    public void edit(Coach coach) {
        coachDAO.edit(coach);
    }

    @Transactional
    public void delete(String username) {
        coachDAO.delete(username);
    }

    @Transactional
    public Coach getCoach(String username) {
        return coachDAO.getCoach(username);
    }

    @Transactional
    public List getAllCoaches(){
        return coachDAO.getAllCoaches();
    }
}
