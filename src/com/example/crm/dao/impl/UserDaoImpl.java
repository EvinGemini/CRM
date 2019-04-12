package com.example.crm.dao.impl;

import com.example.crm.dao.UserDao;
import com.example.crm.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public void save(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    public User findUserByCodeAndPassword(User loginUser) {
        List<User> list = (List<User>) getHibernateTemplate().find("select u from User u where u.user_code = ?0 and u.user_password = ?1",
                loginUser.getUser_code(), loginUser.getUser_password());
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
