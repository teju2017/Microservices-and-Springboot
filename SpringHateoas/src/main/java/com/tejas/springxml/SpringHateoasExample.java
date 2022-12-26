package com.tejas.springxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tejas.springxml.service.Employeeaddition;

@SpringBootApplication
public class SpringHateoasExample {
	


	public static void main(String[] args) {
		
		
		SpringApplication.run(SpringHateoasExample.class, args);
		Employeeaddition.employeeaddition();
	}

}
