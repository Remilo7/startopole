package com.startopole.services.impl;

import com.startopole.dao.UserInfoDAO;
import com.startopole.model.entity.UserInfo;
import com.startopole.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Transactional
    public void add(UserInfo user) {
        userInfoDAO.add(user);
    }

    @Transactional
    public void edit(UserInfo user) {
        userInfoDAO.edit(user);
    }

    @Transactional
    public void delete(String username) {
        userInfoDAO.delete(username);
    }

    @Transactional
    public UserInfo findUserInfo(String userName) {
        return userInfoDAO.findUserInfo(userName);
    }

    @Transactional
    public List getAllUserInfo() {
        return userInfoDAO.getAllUserInfo();
    }
}
