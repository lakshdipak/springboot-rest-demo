package com.infy.dao;

import com.infy.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value = "UserDAO")
public class UserDAOImpl implements UserDAO {

    private Map<Integer, User> users = new HashMap<Integer, User>();

    public UserDAOImpl() {
        users.put(1, new User(1, "12", "Female", "geeta", "Bhosle"));
        users.put(2, new User(2, "13", "Female", "seeta", "Roy"));
    }

    public List<User> getAllUserDetails() {
        return new ArrayList<>(users.values());

    }

    public User getUser(Integer userId, String age, String gender) throws Exception {
        if (null != users.get(userId)) {
            if (users.get(userId).getUserId().equals(userId) && users.get(userId).getAge().equalsIgnoreCase(age)
                    && users.get(userId).getGender().equalsIgnoreCase(gender)) {
                return users.get(userId);
            } else {
                return users.get(null);
            }
        }
        return users.get(null);
    }

    public void addUser(User user) throws Exception {
        users.put(user.getUserId(), user);
    }

}