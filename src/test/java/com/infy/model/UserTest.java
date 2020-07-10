package com.infy.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(User.class)
public class UserTest {

    @Test
    public void UserNotNull() {
        User user = new User(1, "12", "male", "sdd", "dd");
        Assert.assertNotNull(user.getUserId());
        Assert.assertNotNull(user.getAge());
        Assert.assertNotNull(user.getGender());
        Assert.assertNotNull(user.getfName());
        Assert.assertNotNull(user.getlName());
    }

}
