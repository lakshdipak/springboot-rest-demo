package com.infy;

import com.infy.api.UserAPI;
import com.infy.dao.UserDAO;
import com.infy.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoSpringRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringRestApplication.class, args);
	}

}


