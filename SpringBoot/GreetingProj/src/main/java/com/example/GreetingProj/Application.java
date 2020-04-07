package com.example.GreetingProj;

import com.example.GreetingProj.message.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

	@Bean(name = "name")
	public String name(@Value("${name:world}") String nameReadFromProps) {
		return nameReadFromProps;
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		MessageService messageService = (MessageService) context.getBean("messageService");
		System.out.println(messageService.getMessage());
	}
}
