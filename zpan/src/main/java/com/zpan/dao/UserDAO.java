package com.zpan.dao;

import com.zpan.vo.User;

public interface UserDAO {
    public String getEmail(String email);

    public User getUser(User user);

    public void addUser(User user);

    public void update(User user);
}
