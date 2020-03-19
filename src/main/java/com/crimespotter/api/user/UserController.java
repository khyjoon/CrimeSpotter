package com.crimespotter.api.user;

import com.crimespotter.api.user.model.userinfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //# Register a new player
    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public boolean addPlayer(@RequestParam("userName") String userName,
                             @RequestParam("password") String password,
                             @RequestParam("password") String email,
                             @RequestParam("isAdmin") boolean isAdmin) {
        return userService.addUser(userName, password, email, isAdmin);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getPlayersByName() {
        return userService.getAllUsers();
    }


}
