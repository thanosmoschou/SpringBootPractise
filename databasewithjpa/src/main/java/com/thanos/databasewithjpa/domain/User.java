package com.thanos.databasewithjpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User 
{
    @Id
    private String name;
    private int age;

    public void printInfo()
    {
    	System.out.println("Name: " + this.name + " Age: " + this.age);
    }
}
