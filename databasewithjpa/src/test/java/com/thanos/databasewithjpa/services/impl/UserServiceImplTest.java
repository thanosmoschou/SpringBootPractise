package com.thanos.databasewithjpa.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thanos.databasewithjpa.domain.User;
import com.thanos.databasewithjpa.repositories.UserRepository;


/*
 * Mockito is a powerful mocking framework for Java applications. 
 * It allows you to create mock objects, define their behavior, and 
 * verify interactions. To mock dependencies in your unit tests, use 
 * Mockito’s @Mock annotation and @InjectMocks annotation to inject the 
 * mocks into the class under test.
 * 
 * Why Mock?
 * 
 * Why should we use a mock instead of a real service object in a test?
 * Imagine the service implementation above has a dependency to a database or 
 * some other third-party system. We don’t want to have our test run against the 
 * database. If the database isn’t available, the test will fail even though our 
 * system under test might be completely bug-free. The more dependencies we add in 
 * a test, the more reasons a test has to fail. And most of those reasons will be 
 * the wrong ones. If we use a mock instead, we can mock all those potential 
 * failures away.
 * 
 * Aside from reducing failures, mocking also reduces our tests' complexity and 
 * thus saves us some effort. It takes a lot of boilerplate code to set up a 
 * whole network of correctly-initialized objects to be used in a test. 
 * Using mocks, we only have to “instantiate” one mock instead of a whole 
 * rat-tail of objects the real object might need to be instantiated.
 * 
 * In summary, we want to move from a potentially complex, slow, and 
 * flaky integration test towards a simple, fast, and reliable unit test.
 * 
 * As a mocking framework, we’ll use Mockito, since it’s well-rounded, 
 * well-established, and well-integrated into Spring Boot.
 * 
 * Mockito provides some handy annotations that reduce the manual work 
 * of creating mock instances and passing them into the object we’re about to test.
 * 
 * With JUnit Jupiter, we need to apply the MockitoExtension to our test:
 * 
 * We can then use the @Mock and @InjectMocks annotations on fields of the test.
 * 
 * Fields annotated with @Mock will then automatically be initialized with a 
 * mock instance of their type, just like as we would call Mockito.mock() by hand.
 * 
 * Mockito will then try to instantiate fields annotated with @InjectMocks by 
 * passing all mocks into a constructor. Note that we need to provide such a 
 * constructor for Mockito to work reliably. If Mockito doesn’t find a constructor, 
 * it will try setter injection or field injection, but the cleanest way is still 
 * a constructor. You can read about the algorithm behind this in Mockito’s Javadoc.
 * 
 */



@ExtendWith(MockitoExtension.class) //Enable Mockito support
public class UserServiceImplTest 
{
	@Mock
	private UserRepository userRepository; //a fake repository for the test cases
	@InjectMocks
	private UserServiceImpl underTest; //inject the mocked repository to the service
	
	@Test
	public void testIfUserIsSaved()
	{
		User user1 = new User("M", 30);
		User user2 = new User("N", 10);
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		/*
		 * The following method when:
		 * It tells that when you call the findById method of userRepository object with "M" as a parameter then user1 will be returned.
		 * 
		 * It modifies the original behavior of the object's method
		 */

	    /*
		 * Mockito creates mock objects by 
		 * default with a behavior of 
		 * “do nothing”. This means that if a
		 * method is called on a mock object and
		 * no behavior has been specified, the
		 * method will simply return null or the
		 * default value for its return type. It
		 * is important to specify the behavior of
		 * mock objects to ensure that they behave
		 * as expected in tests.
		 * 
		 */
		
		when(userRepository.findById("M")).thenReturn(Optional.of(user1));	
		
		assertEquals(user1, underTest.findUserByName("M").get());
		assertNotEquals(user2, underTest.findUserByName("M").get());	
	}
	
	@Test
	public void testIfAllUsersAreInTheRepository()
	{
		User user1 = new User("M", 30);
		User user2 = new User("N", 10);
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		//When the findAll method is called, return a list of user1 and user2
		//This mocks the original return value
		when(userRepository.findAll()).thenReturn(List.of(user1, user2));
		
		//underTest object calls the findAll method of userRepository inside 
		//its retrieveAllUsers method
		List<User> fetchedUsers = underTest.retrieveAllUsers();
		
		assertEquals(List.of(user1, user2), fetchedUsers);
	}
}
