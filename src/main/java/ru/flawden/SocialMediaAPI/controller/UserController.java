package ru.flawden.SocialMediaAPI.controller;

import org.springframework.web.bind.annotation.*;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.entity.UserInfo;
import ru.flawden.SocialMediaAPI.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping("/add-subscriber")
    public void addSubscriber(@RequestParam Long user_id, @RequestParam Long subscriber_id) {
        userService.addSubscriber(user_id, subscriber_id);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users-details")
    public UserInfo getUserDetails(@RequestParam Long id) {
        return userService.getUserDetails(id);
    }

    @PostMapping("/{id}/users-details")
    public void addUser(@RequestBody UserInfo userInfo, @PathVariable Long id) {
        userService.addUserDetails(userInfo, id);
    }

}
