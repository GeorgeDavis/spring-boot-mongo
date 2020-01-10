package com.mongo.starter;

import com.mongo.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.mongo.*"})
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class StarterApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}

}
