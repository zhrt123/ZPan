package com.zpan.service;

import com.opensymphony.xwork2.ActionContext;
import com.zpan.dao.DiskDAO;
import com.zpan.dao.UserDAO;
import com.zpan.vo.Disk;
import com.zpan.vo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserService {
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

    public User findUser(String email, String password) {
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User u = new User();
        u.setPassword(password);
        u.setEmail(email);
        return userDAO.getUser(u);
    }

    public boolean isEmailExist(String email) {
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        return userDAO.getEmail(email) != null;
    }

    public void addUser(String email, String password) {
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(email);
        userDAO.addUser(user);

        DiskDAO diskDAO = ctx.getBean(DiskDAO.class);
        Disk disk = new Disk();
        disk.setEmail(email);
        disk.setDiskPath("H:\\data\\" + email);
        diskDAO.addDisk(disk);
    }

    public String getDiskPath(String email) {
        DiskDAO diskDAO = ctx.getBean(DiskDAO.class);
        return diskDAO.getDiskPath(email);
    }

    public void modifyUsername(String username) {
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User user = (User) ActionContext.getContext().getSession().get("user");
        user.setUsername(username);
        userDAO.update(user);
        ActionContext.getContext().getSession().put("user", user);
    }

    public void modifyPassword(String password) {
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        User user = (User) ActionContext.getContext().getSession().get("user");
        user.setPassword(password);
        userDAO.update(user);
        ActionContext.getContext().getSession().put("user", user);
    }
}
