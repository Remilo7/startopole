package com.startopole.dao;

import com.startopole.model.entity.Admin;

import java.util.List;

public interface AdminDAO {

    public void add(Admin admin);
    public void edit(Admin admin);
    public void delete(String username);
    public Admin getAdmin(String username);
    public List getAllAdmins();
}
