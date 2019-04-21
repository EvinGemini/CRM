package com.example.crm.web.action;

import com.example.crm.domain.User;
import com.example.crm.service.UserService;
import com.example.crm.utils.MD5Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    public String findAllUser() throws IOException {
        List<User> list = userService.findAllUser();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),list);
        return NONE;
    }

}
