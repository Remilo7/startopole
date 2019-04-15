package com.startopole.services.impl;

import com.startopole.dao.AdminDAO;
import com.startopole.model.entity.Admin;
import com.startopole.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Transactional
    public void add(Admin admin) {
        adminDAO.add(admin);
    }

    @Transactional
    public void edit(Admin admin) {
        adminDAO.edit(admin);
    }

    @Transactional
    public void delete(String username) {
        adminDAO.delete(username);
    }

    @Transactional
    public Admin getAdmin(String username) {
        return adminDAO.getAdmin(username);
    }
}
