package com.example.crm.web.intercepter;

import com.example.crm.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class PermissionIntercepter extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
        HttpSession session = ServletActionContext.getRequest().getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            actionSupport.addActionError("请你登陆后在进行操作");
            return actionSupport.LOGIN;
        }
        return actionInvocation.invoke();
    }
}
