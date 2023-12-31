/*
 * Author: Thanos Moschou
 * Description: My first Spring Boot app.
 */

package com.thanos.HelloWorldApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//I need RestController annotation to tell spring that this class acts like a controller
@RestController
public class HelloController 
{
	
	//I need the GetMapping(path = something) annotation to create an endpoint for my app
	@GetMapping(path = "/hello")
	public String message(@RequestParam(name = "firstName", required = false, defaultValue = "Thanos") String firstName)
	{
		//At the /hello endpoint, message method will be called. This method
		//gets a string parameter and returns a message to the client.
		//How does this method get the parameter? Well this is specified by the 
		//annotation @RequestParam. It says that in the request url I have
		//a variable called firstName which is not required. If user will not provide
		//a value to this variable, then the default value will be assigned to the variable.
		//Request url: localhost:8080/hello?firstName=George
		//or localhost:8080/hello
		//Keep in mind that the parameter inside the method can have different name than URL parameter
		//The annotation that we used to annotate this parameter say that the value from the firstName URL parameter
		//will be assigned to the method parameter (we linked the method parameter with the requested url parameter).
		return "Hello " + firstName + " and welcome to the Spring Boot world!";
	}
}
