package com.thanos.database;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User 
{
	private String name;
	private int age;

	public void printInfo()
	{
		System.out.println("Name: " + this.name + " Age: " + this.age);
	}
}
