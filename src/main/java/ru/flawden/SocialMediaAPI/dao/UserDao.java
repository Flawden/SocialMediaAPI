package ru.flawden.SocialMediaAPI.dao;

import org.springframework.stereotype.Component;
import ru.flawden.SocialMediaAPI.entity.Role;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.entity.UserDetail;
import ru.flawden.SocialMediaAPI.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Component
public class UserDao {

    private UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }
        user.setRoles(Collections.singleton(Role.USER));
//        userRepository.save(user);
//        User testUser = userRepository.findByUsername(user.getUsername());
        user.setUserDetail(new UserDetail(user, "Egor", "Vladimirovi4"));
        userRepository.save(user);

        return true;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        User userForUpdate = userRepository.findUserById(user.getId());

        if (user.getUsername() != null) {
            userForUpdate.setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            userForUpdate.setPassword(user.getPassword());
        }

        userRepository.save(userForUpdate);
    }
}
