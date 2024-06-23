package com.rayennebr.smmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmManagementApplication.class, args);
	}

}
