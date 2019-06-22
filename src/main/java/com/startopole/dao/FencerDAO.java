package com.startopole.dao;

import com.startopole.model.entity.Fencer;

import java.util.List;

public interface FencerDAO {

    public void add(Fencer fencer);
    public void edit(Fencer fencer);
    public void delete(String username);
    public Fencer getFencer(String username);
    public List getAllFencer();
}
