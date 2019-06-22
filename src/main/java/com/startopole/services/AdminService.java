package com.startopole.services;

import com.startopole.model.entity.Admin;

public interface AdminService {
    public void add(Admin admin);
    public void edit(Admin admin);
    public void delete(String username);
    public Admin getAdmin(String username);
}
