package com.thanos.learnAboutConfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
 * In this project I learned how to get the configuration properties from
 * application.properties file which is located in src/main/resources
 * 
 * Remember that with @Configuration annotation you tell spring that it needs to
 * look at this class in order to find some Beans. You can have some beans by
 * declaring methods with @Bean annotation. Here the class
 * is a configuration property bean.
 * 
 * @ConfigurationProperties annotation helps to get the properties from 
 * the configuration file. I specify the prefix to the word person because
 * this will be the prefix of the keys inside the file.
 * 
 * For example:
 * person.name = Makis Kotsampasis
 * person.age = 20
 * 
 * Keep in mind that after the dot, each file property needs to have the same name with the equivalent class attribute.
 * For example person.name and not person.names
 * 
 * If you have the same names just I mentioned, it is not necessary to have the properties in the file
 * with the same order you declared the class attributes. For example here I declared
 * the name first and then the age. Inside the file I can have the person.age first.
 * 
 * If the names after the dot are not the same with the equivalent class attributes then
 * it will create an object calling the default constructor because it was not able to create
 * the String beans.
 * 
 * NOTE: You can use lombok if you want to get rid of all the boilerplate code I wrote here.
 */

@Configuration
@ConfigurationProperties(prefix = "person")
public class Person 
{
	private String name;
	private String age;
	
	public Person()
	{
		this.name = "Thanos";
		this.age = "20";
	}
	
	public Person(String name, String age)
	{
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAge(String age)
	{
		this.age = age;
	}

	public String getName() 
	{
		return name;
	}

	public String getAge() 
	{
		return age;
	}
	
	
}
