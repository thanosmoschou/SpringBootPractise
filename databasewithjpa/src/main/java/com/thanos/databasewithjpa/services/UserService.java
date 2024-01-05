package com.thanos.databasewithjpa.services;

import java.util.List;
import java.util.Optional;

import com.thanos.databasewithjpa.domain.User;

public interface UserService 
{
	public List<User> retrieveAllUsers();
	public Optional<User> findUserByName(String name);
	public void createUser(String name, int age);
	public void deleteUser(String name);
}
