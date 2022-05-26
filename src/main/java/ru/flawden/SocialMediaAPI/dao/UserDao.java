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
