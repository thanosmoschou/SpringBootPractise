package com.thanos.database.daos.impl;

import com.thanos.database.Db;
import com.thanos.database.daos.UserDao;

public class UserDaoImpl implements UserDao
{
	private Db db;
	
	public UserDaoImpl(Db db)
	{
		this.db = db;
	}
	
	@Override
	public void printAllUsers() 
	{
		db.printAllUsers();
	}

}
