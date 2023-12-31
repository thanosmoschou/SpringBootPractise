package com.thanos.learnAboutConfiguration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnAboutConfigurationApplication implements CommandLineRunner
{

	private Person person;
	
	//dependency injection like we learned
	public LearnAboutConfigurationApplication(Person person)
	{
		this.person = person;
	}
	
	
	public static void main(String[] args) 
	{
		SpringApplication.run(LearnAboutConfigurationApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("Person's name: " + person.getName() + 
				" and person's age: " + person.getAge());
	}

}
