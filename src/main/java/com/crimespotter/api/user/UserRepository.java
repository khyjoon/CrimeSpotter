package com.crimespotter.api.user;

import com.crimespotter.api.user.model.userinfo.User;

import java.util.List;

interface UserRepository {
    void addUser(String userName, String password, String email, boolean isAdmin, boolean isBanned);

    List<User> getAllUsers();

    void userPostComment(String userID, String comment);

    void userCreatePost();

    void deleteUser(String userId);
}
