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

package com.thanos.learnThymeleaf.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thanos.learnThymeleaf.model.User;

@Configuration
public class AppConfig 
{

	@Bean
	public ArrayList<User> users()
	{
		return new ArrayList<User>();
	}
}
