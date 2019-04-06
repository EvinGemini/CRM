package com.example.crm.web.action;

import com.example.crm.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }

}
