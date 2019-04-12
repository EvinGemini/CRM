package com.example.crm.web.action;

import com.example.crm.domain.User;
import com.example.crm.service.UserService;
import com.example.crm.utils.MD5Utils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User loginUser = new User();
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getModel() {
        return loginUser;
    }

    public String regist() {
        userService.regist(loginUser);
        return LOGIN;
    }

    public String login() {
        loginUser.setUser_password(MD5Utils.md5(loginUser.getUser_password()));
        User user = userService.login(loginUser);
        if (user == null) {
            //登陆失败
            addActionError("用户名或密码错误！");
            return LOGIN;
        }else {
            //登陆成功
            ActionContext.getContext().getSession().put("user",user);
            return SUCCESS;
        }
    }

}
