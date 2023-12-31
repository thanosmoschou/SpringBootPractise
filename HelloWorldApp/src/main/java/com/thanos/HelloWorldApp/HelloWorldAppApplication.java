/*
 * Author: Thanos Moschou
 * Description: My first Spring Boot app.
 */

package com.thanos.HelloWorldApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//I need the @SpringBootApplication to tell spring that this is my entry point

@SpringBootApplication
public class HelloWorldAppApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(HelloWorldAppApplication.class, args);
	}

}
