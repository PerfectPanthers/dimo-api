package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.entity.User;

public interface UserService {

    User save(User user);

    User findByEmail(String email);
}
