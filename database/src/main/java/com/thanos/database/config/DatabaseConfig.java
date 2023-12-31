package com.thanos.database.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.thanos.database.Db;


@Configuration
public class DatabaseConfig 
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
}
