package com.mongo.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongo.collections.Users;
import com.mongo.repositories.UserRepository;

@SpringBootApplication(scanBasePackages = {"com.mongo.*"})
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class StarterApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		deleteAll();
//		addSampleData();
//		listAll();
//		findFirst();
//		
//	}
//	
//	public void addSampleData() {
//		System.out.println("Adding some sample data...");
//		repo.save(new Users("George", "Charlotte", 100000.00));
//		repo.save(new Users("Gary", "Miami", 200000.00));
//		repo.save(new Users("Michael", "New York", 1000000.00));
//	}
//	
//	public void listAll() {
//		System.out.println("Listing sample data...");
//		repo.findAll().forEach(u -> System.out.println(u));
//	}
//	
//	public void findFirst() {
//		System.out.println("Finding first by Name");
//		Users u = repo.findFirstByName("George");
//		System.out.println("Name = " + u.getName());
//		System.out.println(u);
//	}

}
