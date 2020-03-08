package com.crimespotter.api.user;

interface UserRepository {
    void addUser(String userName, String password, String email, boolean isAdmin);

    void deleteUser(String userId);
}
