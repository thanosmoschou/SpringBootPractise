package com.thanos.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thanos.database.daos.UserDao;

/*
 * In this project I learn how to connect to a mysql database and how I can interact 
 * with the data from the database.
 * 
 * Inside the application.properties file I typed:
 * 
 * spring.datasource.url = jdbc:mysql://localhost:3306/learnspring
 * spring.datasource.username = spring
 * spring.datasource.password = spring
 * spring.datasource.driver-class-name = com.mysql.cj.jdbc.Driver
 * spring.sql.init.mode = always
 * 
 * The spring.sql.init.mode tells spring that it should always run the commands
 * from data.sql and schema.sql every time the app starts
 * 
 * I used xampp because it contains a mysql database. Inside the embedded mysql database
 * I created a user called spring with a password spring and database called learnspring.
 * Then I specified some privileges for the learnspring database to spring user otherwise 
 * the connection was denied.
 * 
 * Keep in mind that is a good idea not to make each service interact with the database by itself.
 * It is good practise to create some Database Access Objects (DAO) to provide some data operations.
 * 
 * Note that if I had multiple Daos, I could be able to combine them using repository pattern.
 * Simply I would create a repositories package with a repository interface and a repository implementation.
 * Inside this implementation I would have my daos in order to retrieve data.
 * Then inside the main application (or inside one service class) I would provide the repository in order to call
 * its methods for accessing data.
 * 
 */

@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner
{
	private UserDao userDao;
	
	//dependency injection
	public DatabaseApplication(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		userDao.printAllUsers();
	}
}
