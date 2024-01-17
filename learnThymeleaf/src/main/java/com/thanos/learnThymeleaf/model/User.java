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

package com.thanos.learnThymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User 
{
	private String name;
	private int age;
	private String phone;
	
	public boolean hasName(String name)
	{
		return this.name.equals(name);
	}
}
