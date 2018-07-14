package com.zpan.action.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.UserService;
import com.zpan.vo.User;

public class LoginAction extends ActionSupport {
    private String email;
    private String password;
    private String loginMessage;
    private UserService userService;

    public String login() {
        User user = userService.findUser(email, password);
        if (user == null) {
            loginMessage = "邮箱或密码错误";
            return ERROR;
        }
        ActionContext.getContext().getSession().put("user", user);
        String path = userService.getDiskPath(user.getEmail());
        ActionContext.getContext().getSession().put("filePath", path);
        String mySharePath = "H:\\sharing\\" + user.getEmail();
        ActionContext.getContext().getSession().put("mySharePath", mySharePath);
        String sharingPath = "H:\\sharing";
        ActionContext.getContext().getSession().put("sharingPath", sharingPath);
        loginMessage = "登录成功";
        return SUCCESS;
    }

    public String logout() {
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }

    public UserService getUserService() {
        return userService;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
