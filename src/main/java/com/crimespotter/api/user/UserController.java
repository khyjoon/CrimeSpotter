package com.crimespotter.api.user;

import com.crimespotter.api.user.model.community.Community;
import com.crimespotter.api.user.model.userinfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public List<User> addUser(@RequestParam("user_name") String userName,
                             @RequestParam("password") String password,
                             @RequestParam("user_email") String email,
                             @RequestParam("isAdmin") boolean isAdmin) {
        return userService.addUser(userName, password, email, isAdmin);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public List<User> updateUsername(@RequestParam("old_user_name") String currUsername,
                                     @RequestParam("new_user_name") String newUsername) {
        return userService.updateUserName(currUsername, newUsername);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.DELETE, value = "/users")
    public boolean removeUser(@RequestParam("userId") String userId) {
        return userService.removeUser(userId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/community")
    public boolean addCommunity(@RequestParam("community_name") String community_name) {
        return userService.addCommunity(community_name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.PUT, value = "/users/usercommunity")
    public boolean addCommunity(@RequestParam("user_id") String userID,
                                @RequestParam("c_id") String cId) {
        return userService.addUserToCommunity(cId, userID);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getUserInfo(@RequestParam(value="user_id", required=false) String userID,
                                  @RequestParam(value="user_name", required=false) String userName,
                                  @RequestParam(value="password", required=false) String password) {
        if (userID.isEmpty() && !userName.isEmpty() && !password.isEmpty()) {
            return userService.getUserByUserPass(userName, password);
        } else if (!userID.isEmpty()) {
            return userService.getUserByID(userID);
        } else {
            return new ArrayList<User>();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/users/usercommunity")
    public List<Community> getAllCommunities() {
        return userService.getAllCommunities();
    }

}
