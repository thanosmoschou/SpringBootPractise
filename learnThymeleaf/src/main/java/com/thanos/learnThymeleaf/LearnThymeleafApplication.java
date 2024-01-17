/*
 * Author: Thanos Moschou
 * Description: Learn to use thymeleaf.
 * I implement a crud app but without any db. Everytime you
 * restart the app, all the data is gone(canned data). 
 * 
 * Useful note: Make sure when you use thymeleaf, all the html tags are closed.
 * Thymeleaf searches pages to src/main/resources/templates.
 * 
 * Use Postman for sending http requests to the web app.
 */

package com.thanos.learnThymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnThymeleafApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(LearnThymeleafApplication.class, args);
	}

}
