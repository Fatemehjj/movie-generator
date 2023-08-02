package com.joolaian.movie.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MovieRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRegistryApplication.class, args);
	}

}
