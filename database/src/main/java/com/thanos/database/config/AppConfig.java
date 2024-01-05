package com.thanos.database.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.thanos.database.Db;
import com.thanos.database.daos.impl.UserDaoImpl;

@Configuration
public class AppConfig 
{
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource) //datasource is created automatically
	{
		return new JdbcTemplate(datasource);
	}
	
	@Bean
	public Db db(JdbcTemplate jdbctemplate)
	{
		return new Db(jdbctemplate);
	}
	
	@Bean
	public UserDaoImpl userDaoImpl(Db db)
	{
		return new UserDaoImpl(db);
	}
}
