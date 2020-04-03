package com.crimespotter.api.user;

import com.crimespotter.api.user.model.community.Community;
import com.crimespotter.api.user.model.userinfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> addUser(String userName, String password, String email, boolean isAdmin) {
        UUID uuid = UUID.randomUUID();
        String user_id = uuid.toString();
        return userRepository.addUser(user_id, userName, password, email, isAdmin, false);
    }

    public boolean addUserToCommunity(String c_id, String user_id) {
        userRepository.addUserToCommunity(c_id, user_id);
        return true;
    }

    public List<User> updateUserName(String currUserName, String newUserName) {
        return userRepository.updateUserName(currUserName, newUserName);
    }

    public boolean addCommunity(String communityName) {
        userRepository.addCommunity(communityName);
        return true;
    }

    public boolean removeUser(String userId) {
        return userRepository.removeUser(userId);
    }

    public List<User> getUserByID(String userID) {
        return userRepository.getUserByID(userID);
    }

    public List<User> getUserByUserPass(String userName,
                                        String password) {
        return userRepository.getUserByUserPass(userName, password);
    }

    public List<Community> getAllCommunities() {
        return userRepository.getAllCommunities();
    }
}
