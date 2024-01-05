package com.thanos.databasewithjpa.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanos.databasewithjpa.domain.User;
import com.thanos.databasewithjpa.repositories.UserRepository;
import com.thanos.databasewithjpa.services.UserService;

//@Service annotation puts this class to the application context

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> retrieveAllUsers() 
	{
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findUserByName(String name) 
	{
		return userRepository.findById(name);
	}

	@Override
	public void createUser(String name, int age) 
	{
		User user = new User(name, age);
		userRepository.save(user);
	}

	@Override
	public void deleteUser(String name) 
	{
		userRepository.deleteById(name);
	}

}
