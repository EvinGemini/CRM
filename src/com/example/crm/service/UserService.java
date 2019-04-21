package com.example.crm.service;

import com.example.crm.domain.User;

import java.util.List;

public interface UserService {
    void regist(User user);

    User login(User loginUser);

    List<User> findAllUser();
}
