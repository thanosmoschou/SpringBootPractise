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

package com.thanos.learnThymeleaf.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.thanos.learnThymeleaf.model.User;

@Component
public class UserRepository 
{
	private ArrayList<User> users;
	
	public UserRepository(ArrayList<User> users)
	{
		this.users = users;
		fillWithFakeData();
	}
	
	private void fillWithFakeData()
	{
		this.users.add(new User("thanos", 20, "6944444444"));
		this.users.add(new User("eleni", 20, "69555555555"));
		this.users.add(new User("gianna", 50, "6911111111"));
	}
	
	public User getUser(String name)
	{
		for(User u : users)
			if(u.hasName(name))
				return u;
		return null;
	}
	
	public List<User> getAllUsers()
	{
		return users;
	}
	
	public void deleteUser(String name)
	{
		for(User u : users)
			if(u.hasName(name))
			{
				users.remove(u);
				break;
			}
	}
	
	public void updateUser(String newUsersName, User newUser)
	{
		for(User u : users)
		{
			if(u.hasName(newUsersName))
			{
				u.setAge(newUser.getAge());
				u.setPhone(newUser.getPhone());
				break;
			}
		}
	}
	
	public void createUser(User user)
	{
		this.users.add(user);
	}
	
}
