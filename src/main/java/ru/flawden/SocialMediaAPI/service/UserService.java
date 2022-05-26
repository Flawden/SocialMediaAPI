package ru.flawden.SocialMediaAPI.service;

import org.springframework.stereotype.Service;
import ru.flawden.SocialMediaAPI.dao.UserDao;
import ru.flawden.SocialMediaAPI.entity.User;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        boolean isAdded = userDao.addUser(user);
        if (isAdded) {
            System.out.println("Заебись");
        } else {
            System.out.println("Не заебись");
        }
    }

    public List<User> getAllUser() {
        return userDao.getUserList();
    }

}
