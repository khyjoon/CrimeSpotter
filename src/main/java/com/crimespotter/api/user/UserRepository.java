package com.crimespotter.api.user;

import com.crimespotter.api.user.model.userinfo.User;

import java.util.List;

interface UserRepository {
    void addUser(String user_id, String user_name, String password, String email, boolean isAdmin, boolean isBanned);

    List<User> getAllUsers();

    void addCommunity(String c_name);

    void addUserToComunity(String c_id, String user_id);

    void deleteUser(String userId);
}
