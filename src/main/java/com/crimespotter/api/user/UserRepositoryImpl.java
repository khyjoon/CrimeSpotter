package com.crimespotter.api.user;

import com.crimespotter.api.user.model.community.Community;
import com.crimespotter.api.user.model.community.CommunityMapper;
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
    public List<User> addUser(String user_id, String user_name, String password, String user_email, boolean isAdmin, boolean isBanned) {
        String query =
                "INSERT INTO User (user_id, password, user_name, user_email, isBanned, isAdmin)\n" +
                        "VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(query, user_id, password, user_name, user_email, isBanned, isAdmin);
        String readQuery =
                "SELECT *\n" +
                        "FROM User\n" +
                        "WHERE user_id = ?";
        List<User> user = jdbcTemplate.query(readQuery, new UserMapper(), user_id);
        return user;
    }

    // this is the add community function
    @Override
    public void addCommunity(String c_name) {
        String query =
                "INSERT INTO Community (c_name)\n" +
                        "VALUES (?)";
        jdbcTemplate.update(query, c_name);
    }

    @Override
    public void addUserToCommunity(String c_id, String user_id) {
        String query =
                "INSERT INTO UserCommunity (user_id, c_id)\n" +
                        "VALUES (?,?)";
        jdbcTemplate.update(query, user_id, c_id);
    }

    @Override
    public List<User> updateUserName(String currUsername, String newUsername) {
        String updateQuery = "UPDATE User\n" +
                                    "SET user_name = ?\n" +
                                        "WHERE user_name = ?;";
        jdbcTemplate.update(updateQuery, currUsername, newUsername);
        return getUserByUserName(newUsername);
    }

    @Override
    public List<User> getAllUsers() {
        String readQuery =
                "SELECT *\n" +
                        "FROM User\n" +
                        "ORDER BY user_id DESC";

        List<User> users = jdbcTemplate.query(readQuery, new UserMapper());
        return users;
    }

    @Override
    public boolean removeUser(String userId) {
        String deleteQuery =
                "DELETE FROM User\n" +
                        "WHERE user_id = ?";
        jdbcTemplate.update(deleteQuery, userId);
        return true;
    }

    @Override
    public List<User> getUserByID(String userID) {
        String readQuery =
                "SELECT *\n" +
                        "FROM User\n" +
                        "WHERE user_id = ?";
        List<User> user = jdbcTemplate.query(readQuery, new UserMapper(), userID);
        return user;
    }

    @Override
    public List<User> getUserByUserPass(String userName, String password) {
        String readQuery =
                "SELECT *\n" +
                        "FROM User\n" +
                        "WHERE user_name = ? AND password = ?";
        List<User> user = jdbcTemplate.query(readQuery, new UserMapper(), userName, password);
        return user;
    }

    @Override
    public List<User> getUserByUserName(String userName) {
        String readQuery =
                "SELECT *\n" +
                        "FROM User\n" +
                        "WHERE user_name = ?";
        List<User> user = jdbcTemplate.query(readQuery, new UserMapper(), userName);
        return user;
    }

    @Override
    public List<Community> getAllCommunities() {
        String readQuery =
                "SELECT *\n" +
                        "FROM Community\n" +
                        "ORDER BY c_id ASC";
        List<Community> communities = jdbcTemplate.query(readQuery, new CommunityMapper());
        return communities;
    }
}
