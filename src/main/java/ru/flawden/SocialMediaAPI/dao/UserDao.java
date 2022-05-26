package ru.flawden.SocialMediaAPI.dao;

import org.springframework.stereotype.Component;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.repository.UserRepository;

import java.util.List;

@Component
public class UserDao {

    private UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(User user) {
//        User userFromDb = userRepository.findByUsername(user.getUsername());

//        if (userFromDb != null) {
//            return false;
//        }

        userRepository.save(user);

        return true;
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

}
