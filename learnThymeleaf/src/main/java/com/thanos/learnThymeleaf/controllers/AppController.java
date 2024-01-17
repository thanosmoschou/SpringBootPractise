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

package com.thanos.learnThymeleaf.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.thanos.learnThymeleaf.model.User;
import com.thanos.learnThymeleaf.repos.UserRepository;

@Controller
public class AppController 
{
	private UserRepository userRepository;
	
	public AppController(UserRepository userRepo)
	{
		this.userRepository = userRepo;
	}
	
	@GetMapping(path = "/")
	public String index()
	{
		return "index";
	}
		
	@GetMapping(path = "/users/{name}")
	public String getUser(@PathVariable String name, Model model)
	{
		User user = this.userRepository.getUser(name);
		
		//specify a model for our dynamic page
		//we add data to this model and thymeleaf prints it out
		model.addAttribute("returnedUsers", user);
		return "dynamic";
	}
	
	@GetMapping(path = "/users")
	public String getAllUsers(Model model)
	{
		List<User> allUsers = this.userRepository.getAllUsers();
		model.addAttribute("returnedUsers", allUsers);
		return "dynamic";
	}
	
	@PutMapping(path = "/users/{name}")
	public String updateUser(@PathVariable String name, @RequestBody User user, Model model)
	{
		this.userRepository.updateUser(name, user);
		User updatedUser = this.userRepository.getUser(name);
		model.addAttribute("returnedUsers", updatedUser);
		return "dynamic";
	}
	
	@PostMapping(path = "/users")
	public String createUser(@RequestBody User user, Model model)
	{
		this.userRepository.createUser(user);
		model.addAttribute("returnedUsers", user);
		return "dynamic";
	}
	
	@DeleteMapping(path = "/users/{name}")
	public String deleteUser(@PathVariable String name, Model model)
	{
		this.userRepository.deleteUser(name);
		List<User> users = this.userRepository.getAllUsers();
		model.addAttribute("returnedUsers", users);
		return "dynamic";
		
	}
	
}
