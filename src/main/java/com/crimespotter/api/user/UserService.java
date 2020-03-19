package com.crimespotter.api.user;

import com.crimespotter.api.user.model.userinfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean addUser(String userName, String password, String email, boolean isAdmin) {
        userRepository.addUser(userName, password, email, isAdmin, false);
        return true;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
