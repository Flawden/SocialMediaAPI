package ru.flawden.SocialMediaAPI.service;

import org.springframework.stereotype.Service;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.entity.UserInfo;
import ru.flawden.SocialMediaAPI.repository.UserDetailRepository;
import ru.flawden.SocialMediaAPI.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

//Перенести из UserDAO логику сюда

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private UserDetailRepository userDetailRepository;

    public UserService(UserRepository userRepository, UserDetailRepository userDetailRepository) {
        this.userRepository = userRepository;
        this.userDetailRepository = userDetailRepository;
    }

    public void addUser(User user) {
        User userSaved = userRepository.save(user); //Сохраненный пользователь с айдишником
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        User userForUpdate = userRepository.findById(user.getId()).orElseThrow( () -> new RuntimeException("User not found"));

        if (user.getUsername() != null) {
            userForUpdate.setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            userForUpdate.setPassword(user.getPassword());
        }

        userRepository.save(userForUpdate);
    }

    public void addUserDetails(UserInfo userInfo, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userInfo.setUser(user);
        userDetailRepository.save(userInfo);
    }

    public UserInfo getUserDetails(Long id) {
        return userDetailRepository.findUserDetailById(id);
    }

    public void addSubscriber(Long user_id, Long subscriber_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User does not exist"));
        User subscriber = userRepository.findById(subscriber_id).orElseThrow(() -> new RuntimeException("User does not exist"));

        user.addSubscriber(subscriber);
        userRepository.save(user);
    }
}
