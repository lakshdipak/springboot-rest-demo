package com.infy.api;

import com.infy.model.User;
import com.infy.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserAPI.class)
public class UserAPITest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserAPI userAPI;

    @MockBean
    private UserServiceImpl userServiceiml;

    @Test
    public void getAllUserDetails() throws Exception {

        User user = new User();
        user.setUserId(111);

        List<User> allUser = singletonList(user);

        given(userAPI.getAllUserDetails()).willReturn(new ResponseEntity(allUser, HttpStatus.OK));

        mvc.perform(get("/infosys/users")
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    public void getUserDetails() throws Exception {
        User user = new User();
        user.setUserId(111);
        user.setAge("45");
        user.setGender("Male");
        given(userAPI.getUserDetails(user.getUserId(), user.getAge(), user.getGender())).willReturn(new ResponseEntity(user, HttpStatus.OK));

        mvc.perform(get("/infosys/users/" + user.getUserId() + "/" + user.getAge() + "/" + user.getGender())
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("userId", is(user.getUserId())));
    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        String errorMessage = "Bad Request";

        given(userAPI.addUser(user)).willReturn(new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST));

        mvc.perform(post("/infosys/users", user)
                .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().is4xxClientError());
    }

}
