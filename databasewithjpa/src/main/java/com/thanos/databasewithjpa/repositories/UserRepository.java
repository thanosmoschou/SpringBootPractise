package com.thanos.databasewithjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thanos.databasewithjpa.domain.User;

//@Repository puts the repository to the spring context
//It also says to spring that this is a repository, a thing that we use to interact with the persistence layer.
//By extending JpaRepository we get some methods for free. Spring will implement them for us.
//JpaRepository gets some generic: The entity's class type and the id's type.

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
	
} 
