package com.example.crm.dao;

import com.example.crm.domain.User;

public interface UserDao {
    void save(User user);

    User findUserByCodeAndPassword(User loginUser);
}
