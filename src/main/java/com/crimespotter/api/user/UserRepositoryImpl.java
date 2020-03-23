package com.crimespotter.api.user;

import com.crimespotter.api.user.model.userinfo.User;
import com.crimespotter.api.user.model.userinfo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(String user_id, String user_name, String password, String user_email, boolean isAdmin, boolean isBanned) {
        String query =
                "INSERT INTO user (user_id, user_name, password, user_email, isAdmin, isBanned)\n" +
                        "VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(query, user_id, user_name, password, user_email, isAdmin, isBanned);
    }

    @Override
    public void addCommunity(String c_name) {
        String query =
                "INSERT INTO Community (c_name)\n" +
                        "VALUES (?)";
        jdbcTemplate.update(query, c_name);
    }

    @Override
    public List<User> getAllUsers() {
        String readQuery =
                "SELECT *\n" +
                        "FROM user\n" +
                        "ORDER BY user_id DESC";

        List<User> users = jdbcTemplate.query(readQuery, new UserMapper());
        return users;
    }

    @Override
    public void deleteUser(String userId) {
        String deleteQuery =
                "DELETE FROM user\n" +
                        "WHERE user_id = ?";
        jdbcTemplate.update(deleteQuery, userId);
    }
}
