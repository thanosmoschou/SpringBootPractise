package com.thanos.database;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

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
 */

@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner
{
	private DataSource datasource; //This creates a connection object
	private JdbcTemplate jdbctemplate; //With this object I can communicate with my database by executing queries
	private Db db;
	
	//dependency injection
	public DatabaseApplication(DataSource datasource, JdbcTemplate jdbctemplate, Db db)
	{
		this.datasource = datasource;
		this.jdbctemplate = jdbctemplate; 
		this.db = db;
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println(datasource.toString());		
		db.printAllUsers();
	}
}
