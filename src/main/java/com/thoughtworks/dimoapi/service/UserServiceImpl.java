package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.entity.User;
import com.thoughtworks.dimoapi.repository.UserRepository;
import com.thoughtworks.dimoapi.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        String encryptedPassword = PasswordUtils.encrypt(user.getPassword());
        user.setPassword(encryptedPassword);
        if (user.getPreferences().size() == 0) {
            user.setPreferences(new ArrayList<>(Arrays.asList("en", "28")));
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
