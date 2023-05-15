package com.bridgelabz.employeepayroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeepayrollApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(EmployeepayrollApplication.class, args);
//		System.out.println("Welcome to Employee Payroll");
		log.info("Application is started in {} Environment",context.getEnvironment().getProperty("environment"));
		log.info("Application is started DB {} User",context.getEnvironment().getProperty("spring.datasource.username"));

	}

}
