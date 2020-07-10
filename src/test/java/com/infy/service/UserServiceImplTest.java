package com.infy.service;

import com.infy.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserServiceImpl.class)
public class UserServiceImplTest {

    @MockBean
    private UserServiceImpl userService;

    @Test
    public void getAllUserDetails() throws Exception {
        User user = new User();
        user.setUserId(111);

        List<User> allUser = singletonList(user);

        when(userService.getAllUserDetails()).thenReturn(allUser);

        Assert.assertNotNull(userService.getAllUserDetails());
    }

    @Test
    public void getUserDetails() throws Exception {
        User user = new User();
        user.setUserId(111);
        user.setAge("45");
        user.setGender("Male");

        when(userService.getUser(any(), anyString(), anyString())).thenReturn(user);

        Assert.assertNotNull(userService.getUser(user.getUserId(), user.getAge(), user.getGender()));
        Assert.assertEquals(userService.getUser(user.getUserId(), user.getAge(), user.getGender()), user);

    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        userService.addUser(user);
        userService.addUser(user);
        verify(userService, times(2)).addUser(user);
    }
}
