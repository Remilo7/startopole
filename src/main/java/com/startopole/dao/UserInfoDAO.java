package com.startopole.dao;

import com.startopole.model.entity.UserInfo;

import java.util.List;

public interface UserInfoDAO {

    public UserInfo findUserInfo(String userName);

    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);

    public void setUserInfo(List<String> data);
}