package com.startopole.services.impl;

import com.startopole.dao.FencerDAO;
import com.startopole.model.entity.Fencer;
import com.startopole.services.FencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FencerServiceImpl implements FencerService {

    @Autowired
    private FencerDAO fencerDAO;

    @Transactional
    public void add(Fencer fencer) {
        fencerDAO.add(fencer);
    }

    @Transactional
    public void edit(Fencer fencer) {
        fencerDAO.edit(fencer);
    }

    @Transactional
    public void delete(String username) {
        fencerDAO.delete(username);
    }

    @Transactional
    public Fencer getFencer(String username) {
        return fencerDAO.getFencer(username);
    }

    @Transactional
    public List getAllFencer(){
        return fencerDAO.getAllFencer();
    }
}
