package ru.flawden.SocialMediaAPI.controller;

import org.springframework.web.bind.annotation.*;
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
        return userService.getAllUser();
    }

    @PostMapping("/registration")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/users")
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

}
