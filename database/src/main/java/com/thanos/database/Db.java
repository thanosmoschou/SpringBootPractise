package com.thanos.database;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Db 
{
	private ArrayList<User> users;
	private JdbcTemplate jdbctemplate;
	
	public Db(JdbcTemplate jdbctemplate)
	{
		this.jdbctemplate = jdbctemplate;
		users = new ArrayList<>();
	}
	
	
	private void getAllUsers()
	{
		String query = "select name, age from users;";
		
		SqlRowSet set = jdbctemplate.queryForRowSet(query);		
		while(set.next())
			users.add(new User(set.getString("name"), set.getInt("age")));
	}
	
	
	public void printAllUsers()
	{
		if(users.isEmpty())
			getAllUsers();
		
		for(User user : users)
			user.printInfo();
	}
	
}
