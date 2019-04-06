package com.example.crm.service.impl;

import com.example.crm.dao.UserDao;
import com.example.crm.domain.User;
import com.example.crm.service.UserService;
import com.example.crm.utils.MD5Utils;

import javax.transaction.Transactional;

@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void regist(User user) {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        user.setUser_state("1");
        userDao.save(user);
    }
}
