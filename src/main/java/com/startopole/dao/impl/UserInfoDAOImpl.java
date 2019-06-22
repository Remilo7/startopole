package com.startopole.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import com.startopole.dao.UserInfoDAO;
import com.startopole.mapper.UserInfoMapper;
import com.startopole.model.entity.UserInfo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

    @Autowired
    private SessionFactory session;

    public void add(UserInfo user) {
        session.getCurrentSession().save(user);
    }

    public void edit(UserInfo user) {
        session.getCurrentSession().update(user);
    }

    public void delete(String username) {
        session.getCurrentSession().delete(findUserInfo(username));
    }

    public UserInfo findUserInfo(String userName) {
        return session.getCurrentSession().get(UserInfo.class, userName);
    }

    public List getAllUserInfo(){
        return session.getCurrentSession().createQuery("FROM UserInfo").list();
    }

}