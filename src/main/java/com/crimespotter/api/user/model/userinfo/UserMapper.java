package com.crimespotter.api.user.model.userinfo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("user_id"));
        user.setUserName(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("user_email"));
        user.setBanned(resultSet.getBoolean("isBanned"));
        user.setAdmin(resultSet.getBoolean("isAdmin"));
        return user;
    }
}
