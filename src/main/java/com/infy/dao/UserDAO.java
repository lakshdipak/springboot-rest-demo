package com.infy.dao;

import com.infy.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUserDetails();

    public User getUser(Integer userId, String age, String gender) throws Exception;

    public void addUser(User user) throws Exception;

}
