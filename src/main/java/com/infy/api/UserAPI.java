package com.infy.api;

import com.infy.model.User;
import com.infy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/infosys")
public class UserAPI {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUserDetails() throws Exception {
        List<User> userList = userService.getAllUserDetails();
        ResponseEntity<List<User>> response = new ResponseEntity<List<User>>(userList, HttpStatus.OK);
        return response;
    }


    @GetMapping(value = "/users/{userId}/{age}/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserDetails(@PathVariable Integer userId, @PathVariable String age,
                                               @PathVariable String gender) throws Exception {
        User user = userService.getUser(userId, age, gender);
        ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.OK);
        return response;
    }


    @PostMapping(value = "/users")
    public ResponseEntity<String> addUser(@RequestBody User user) throws Exception {
        userService.addUser(user);
        String successMessage = "User added successfully";
        ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
        return response;
    }
}
