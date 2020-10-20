package com.user.jattana.DAO;

import com.user.jattana.Model.User;

import java.util.List;

public interface UserDAO {

    public long addUser(User user);
    public int updateUser(User user, String email);
    public long deleteUser(String email);
    public User getUser(String email);
    public List<User> getUserList();
}
