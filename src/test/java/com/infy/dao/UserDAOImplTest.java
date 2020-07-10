package com.infy.dao;

import com.infy.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserDAOImpl.class)
public class UserDAOImplTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserDAOImpl userDAO;

    @Test
    public void getAllUserDetails() throws Exception {

        User user = new User();
        user.setUserId(111);

        List<User> allUser = singletonList(user);

        when(userDAO.getAllUserDetails()).thenReturn(allUser);

        Assert.assertNotNull(userDAO.getAllUserDetails());
    }

    @Test
    public void getUserDetails() throws Exception {
        User user = new User();
        user.setUserId(111);
        user.setAge("45");
        user.setGender("Male");

        when(userDAO.getUser(any(), anyString(), anyString())).thenReturn(user);

        Assert.assertNotNull(userDAO.getUser(user.getUserId(), user.getAge(), user.getGender()));
        Assert.assertEquals(userDAO.getUser(user.getUserId(), user.getAge(), user.getGender()), user);

    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        userDAO.addUser(user);
        verify(userDAO, times(1)).addUser(user);
        Assert.assertNotNull(user);
    }
}