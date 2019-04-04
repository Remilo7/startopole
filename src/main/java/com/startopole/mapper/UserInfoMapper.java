package com.startopole.mapper;

import com.startopole.model.UserInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoMapper implements RowMapper<UserInfo> {

    public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

        String userName = rs.getString("Username");
        String password = rs.getString("Password");

        return new UserInfo(userName, password);
    }

}