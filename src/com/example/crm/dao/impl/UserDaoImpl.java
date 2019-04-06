package com.example.crm.dao.impl;

import com.example.crm.dao.UserDao;
import com.example.crm.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public void save(User user) {
        getHibernateTemplate().save(user);
    }
}
