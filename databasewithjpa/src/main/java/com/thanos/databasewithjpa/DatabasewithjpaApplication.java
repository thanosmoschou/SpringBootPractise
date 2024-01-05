package com.thanos.databasewithjpa;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thanos.databasewithjpa.domain.User;
import com.thanos.databasewithjpa.services.UserService;

/*
 * database project explains how to use jdbc to interact with a database.
 * databasewithjpa explains how to use spring data jpa to interact with our db.
 * 
 * JPA is a higher level mechanism for connecting and interacting with a database using java objects.
 * It creates the sql commands for us.
 * 
 * When to use Spring Data JPA?
 * I would say that if you need to quickly create a JPA-based repository layer that is mainly for CRUD operations, 
 * and you do not want to create abstract DAO, implementing interfaces, Spring Data JPA is a good choice.
 */

@SpringBootApplication
public class DatabasewithjpaApplication implements CommandLineRunner
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService userService;

	public DatabasewithjpaApplication(UserService userService)
	{
		this.userService = userService;
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(DatabasewithjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		String searchingName = "Makis Kotsampasis";
		User user = userService.findUserByName(searchingName).get();
		
		System.out.println("**************");
		if(user != null)
			user.printInfo();
		
		System.out.println("**************");
		for(User u : userService.retrieveAllUsers())
			u.printInfo();
		
		userService.createUser("Eva Mavrotsoukalou", 22);
		
		System.out.println("**************");
		for(User u : userService.retrieveAllUsers())
			u.printInfo();
		
		userService.deleteUser("Thanos Moschou");
		
		System.out.println("**************");
		for(User u : userService.retrieveAllUsers())
			u.printInfo();
		
	}

}
