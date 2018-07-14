package com.zpan.action.user;

import com.opensymphony.xwork2.ActionSupport;
import com.zpan.service.UserService;

public class RegisterAction extends ActionSupport {
    private String email;
    private String password1;
    private String password2;
    private String registerMessage;
    private UserService userService;

    public String register() {
        if (userService.isEmailExist(email)) {
            registerMessage = "邮箱已被注册";
            return ERROR;
        }
        userService.addUser(email, password1);
        return SUCCESS;
    }


    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }

    public String getRegisterMessage() {
        return registerMessage;
    }

    public void setRegisterMessage(String registerMessage) {
        this.registerMessage = registerMessage;
    }

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

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
