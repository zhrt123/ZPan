package com.zpan.action.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.UserService;
import com.zpan.vo.User;

public class ProfileAction extends ActionSupport {
    private String email;
    private String username;
    private String password1;
    private String password2;
    private String password3;
    private UserService userService;

    public UserService getUserService() {
        return userService;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPassword3() {
        return password3;
    }

    public void setPassword3(String password3) {
        this.password3 = password3;
    }

    public String excute() {
        return SUCCESS;
    }

    public String modifyAccountGeneral() {
        userService.modifyUsername(username);
        return SUCCESS;
    }

    public String modifyAccountPassword() {
        userService.modifyPassword(password2);
        return SUCCESS;
    }
}
