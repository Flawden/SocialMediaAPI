package ru.flawden.SocialMediaAPI.service;

import org.springframework.stereotype.Service;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.entity.UserInfo;
import ru.flawden.SocialMediaAPI.exception.UserNotFoundException;
import ru.flawden.SocialMediaAPI.repository.UserDetailRepository;
import ru.flawden.SocialMediaAPI.repository.UserRepository;
import ru.flawden.SocialMediaAPI.util.ValidationUtil;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final ValidationUtil validationUtil;
    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;

    public UserService(ValidationUtil validationUtil, UserRepository userRepository, UserDetailRepository userDetailRepository) {
        this.validationUtil = validationUtil;
        this.userRepository = userRepository;
        this.userDetailRepository = userDetailRepository;
    }

    public void addUser(User user) {
        validationUtil.validateEmail(user.getEmail());
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        User userForUpdate = userRepository.findById(user.getId()).orElseThrow( () -> new UserNotFoundException("User not found"));

        if (user.getEmail() != null) {
            validationUtil.validateEmail(user.getEmail());
            userForUpdate.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            userForUpdate.setPassword(user.getPassword());
        }

        userRepository.save(userForUpdate);
    }

    public void addUserDetails(UserInfo userInfo, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        validationUtil.validatePhoneNumber(userInfo.getPhoneNumber());
        user.setUserInfo(userInfo);
        userDetailRepository.save(userInfo);
    }

    public UserInfo getUserDetails(Long id) {
        return userDetailRepository.findUserDetailById(id);
    }

    public void addSubscriber(Long user_id, Long subscriber_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new UserNotFoundException("User does not exist"));
        User subscriber = userRepository.findById(subscriber_id).orElseThrow(() -> new UserNotFoundException("User does not exist"));

        user.addSubscriber(subscriber);
        userRepository.save(user);
    }
}
