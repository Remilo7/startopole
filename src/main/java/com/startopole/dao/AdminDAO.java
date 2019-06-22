package com.startopole.dao;

import com.startopole.model.entity.Admin;

public interface AdminDAO {

    public void add(Admin admin);
    public void edit(Admin admin);
    public void delete(String username);
    public Admin getAdmin(String username);
}
