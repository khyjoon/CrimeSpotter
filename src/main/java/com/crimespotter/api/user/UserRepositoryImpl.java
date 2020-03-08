package com.crimespotter.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(String userName, String password, String email, boolean isAdmin) {
        String query =
                "INSERT INTO user (userName, password, email, isAdmin)\n" +
                        "VALUES (?,?,?,?)";
        jdbcTemplate.update(query, userName, password, email, isAdmin);
    }

    @Override
    public void deleteUser(String userId) {
        String deleteQuery =
                "DELETE FROM user\n" +
                        "WHERE user_id = ?";
        jdbcTemplate.update(deleteQuery, userId);
    }
}
