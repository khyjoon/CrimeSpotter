package com.crimespotter.api.user;

import com.crimespotter.api.user.model.userinfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean addUser(String userName, String password, String email, boolean isAdmin) {
        UUID uuid = UUID.randomUUID();
        String user_id = uuid.toString();
        userRepository.addUser(user_id, userName, password, email, isAdmin, false);
        return true;
    }

    public boolean addUserToCommunity(String c_id, String user_id) {
        userRepository.addUserToComunity(c_id, user_id);
        return true;
    }

    public boolean addCommunity(String communityName) {
        userRepository.addCommunity(communityName);
        return true;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
