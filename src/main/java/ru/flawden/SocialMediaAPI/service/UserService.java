package ru.flawden.SocialMediaAPI.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.flawden.SocialMediaAPI.dao.UserDao;
import ru.flawden.SocialMediaAPI.entity.User;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        boolean isAdded = userDao.addUser(user);
        if (isAdded) {
            System.out.println("Well done");
        } else {
            System.out.println("Fail");
        }
    }

    public List<User> getAllUser() {
        return userDao.getUserList();
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByUsername(username);
    }
}
