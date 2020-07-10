package com.infy.service;

import com.infy.dao.UserDAO;
import com.infy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUserDetails() throws Exception {
        List<User> userList = userDAO.getAllUserDetails();
        if (userList == null) {
            throw new Exception("Service.NO_User_AVAILABLE");
        }
        return userList;
    }

    public User getUser(Integer userId, String age, String gender) throws Exception {

        User user = (User) userDAO.getUser(userId, age, gender);

        if (user == null) {
            throw new Exception("Service.NO_User_AVAILABLE");
        }
        return user;
    }

    public void addUser(User user) throws Exception {
        if (userDAO.getUser(user.getUserId(), user.getAge(), user.getGender()) != null) {
            throw new Exception("Service.User_ALREADY_EXISTS");
        }
        userDAO.addUser(user);
    }

}
