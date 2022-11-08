package com.crud.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
public class TasksApplication extends SpringBootServletInitializer {
/*
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TasksApplication.class);
	}
 */

	public static void main(String[] args) {

		/* String mailUser = System.getenv("MAIL_USERNAME");
		String mailPassword = System.getenv("MAIL_PASSWORD");

		System.out.println("MAIL_USERNAME: " + mailUser + " MAIL_PASSWORD: " + mailPassword);

		 */

		SpringApplication.run(TasksApplication.class, args);

	}
}
