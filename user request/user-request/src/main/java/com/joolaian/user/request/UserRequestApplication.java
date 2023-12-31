package com.joolaian.user.request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRequestApplication.class, args);
	}

}
