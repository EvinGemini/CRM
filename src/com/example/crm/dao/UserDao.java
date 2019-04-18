package com.example.crm.dao;

import com.example.crm.domain.User;

public interface UserDao extends BaseDao<User>{
    User findUserByCodeAndPassword(User loginUser);
}
