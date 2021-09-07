package com.tejas.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.tejas.backend.pojo")
public class BackendDatabaseLoadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendDatabaseLoadingApplication.class, args);
	}

}
