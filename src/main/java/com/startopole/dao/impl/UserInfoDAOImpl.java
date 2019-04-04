package com.startopole.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import com.startopole.dao.UserInfoDAO;
import com.startopole.mapper.UserInfoMapper;
import com.startopole.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoDAOImpl extends JdbcDaoSupport implements UserInfoDAO {

    @Autowired
    public UserInfoDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    public UserInfo findUserInfo(String userName) {
        String sql = "SELECT u.Username,u.Password\n" +
                "FROM USERS u\n" +
                "WHERE u.Username = ?";

        Object[] params = new Object[] { userName };
        UserInfoMapper mapper = new UserInfoMapper();
        try {
            UserInfo userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public List<String> getUserRoles(String userName) {
        String sql = "SELECT r.User_Role "//
                + " FROM USER_ROLES r WHERE r.Username = ? ";

        Object[] params = new Object[] { userName };

        List<String> roles = this.getJdbcTemplate().queryForList(sql,params, String.class);

        return roles;
    }

    public void setUserInfo(List<String> data){

        String v1 = data.get(0);
        String v2 = data.get(1);

        String sql = "INSERT INTO\n" +
                "  USERS(USERNAME, PASSWORD, ENABLED)\n" +
                "VALUES("+v1+","+v2+",0)";

        this.getJdbcTemplate().execute(sql);
    }

}