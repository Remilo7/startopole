package com.startopole.services;

import com.startopole.model.entity.Fencer;

import java.util.List;

public interface FencerService {
    public void add(Fencer fencer);
    public void edit(Fencer fencer);
    public void delete(String username);
    public Fencer getFencer(String username);
    public List getAllFencer();
}
