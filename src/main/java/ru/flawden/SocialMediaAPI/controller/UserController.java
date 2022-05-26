package ru.flawden.SocialMediaAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        userService.addUser(new User("Volodia"));
        return userService.getAllUser();
    }

}
