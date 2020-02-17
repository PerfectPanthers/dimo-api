package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.model.Login;
import com.thoughtworks.dimoapi.repository.UserRepository;
import com.thoughtworks.dimoapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public void save(User user) {
      userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }



}
