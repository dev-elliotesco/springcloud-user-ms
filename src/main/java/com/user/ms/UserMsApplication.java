package com.user.ms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserMsApplication {

	private static final Logger logger = LoggerFactory.getLogger(UserMsApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(UserMsApplication.class, args);
		logger.info("Welcome to User Microservice!");
	}

}
