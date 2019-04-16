package com.startopole.services;

import com.startopole.model.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    public void add(UserInfo user);
    public void edit(UserInfo user);
    public void delete(String username);
    public UserInfo findUserInfo(String userName);
    public List getAllUserInfo();
}
