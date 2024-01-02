package com.example.colors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.colors.services.BluePrinter;
import com.example.colors.services.ColorPrinter;
import com.example.colors.services.GreenPrinter;
import com.example.colors.services.RedPrinter;
import com.example.colors.services.impl.ColorPrinterImpl;
import com.example.colors.services.impl.SpanishBluePrinter;
import com.example.colors.services.impl.SpanishGreenPrinter;
import com.example.colors.services.impl.SpanishRedPrinter;


/*
In Spring Boot, a bean is a Java object managed by the Spring framework's IoC (Inversion of Control) container. It is a fundamental building block of a Spring application and represents a reusable component that can be wired together with other beans to create the application's functionality.

@Bean is used to define individual beans explicitly in Spring. When you create a method annotated with @Bean within a Spring @Configuration class, Spring will register the return value of that method as a bean in the Spring application context. You can use this annotation to customize the instantiation and configuration of specific beans, and it allows you to have fine-grained control over the objects created by Spring.

@Configuration is used to indicate that a class defines Spring bean configurations. When you annotate a class with @Configuration, it tells Spring that this class contains one or more @Bean definitions or other bean-related configurations. Spring will process the bean definitions inside the @Configuration class and add them to the application context.

@EnableAutoConfiguration is used to enable Spring Boot's auto-configuration mechanism. When you annotate your main class (the one annotated with @SpringBootApplication) or any other configuration class with @EnableAutoConfiguration, Spring Boot will automatically attempt to configure the application based on the dependencies and the classpath. It will enable sensible defaults for various configurations, such as database connections, message queues, and web frameworks, among others. Essentially, it allows you to let Spring Boot do much of the configuration work for you, based on the dependencies present in your project.

In summary, @Bean is used to explicitly define individual beans in a Spring application, @Configuration is used to define a class as a source of bean configurations, and @EnableAutoConfiguration is used to enable Spring Boot's automatic configuration feature, which simplifies the setup of your application by configuring beans based on classpath and dependencies.
*/


@Configuration
public class PrinterConfig 
{
	
	/*
	 * Each method will create a Bean to be managed by the Spring container
	 * Now that I have these Beans I can inject them wherever they are needed
	 */

	@Bean
	public RedPrinter redPrinter()
	{
		//The implementation of this method will return the implementation of RedPrinter

		//Remember from theory that interface types can also be used for declaring some objects
		//but you cannot use them with the new keyword to create objects of that interface.
		//You can only create objects of classes that implement this interface but their type
		//can also be declared as the interface name
		
		//For example:
		//RedPrinter printer = new EnglishRedPrinter(); this is valid if EnglishRedPrinter implements RedPrinter interface
		//RedPrinter printer = new Printer(); this is not valid because you cannot use the interface name to create objects
		//return new EnglishRedPrinter();
		
		//Now I can change the implementation here without having to change anything else on the project
		//I declared interfaces there and I created Beans as concrete classes and spring will inject them 
		//to the interface declarations
		return new SpanishRedPrinter();
	}
	
	@Bean
	public BluePrinter bluePrinter()
	{
		//return new EnglishBluePrinter();
		return new SpanishBluePrinter();

	}
	
	@Bean
	public GreenPrinter greenPrinter()
	{
		//return new EnglishGreenPrinter();
		return new SpanishGreenPrinter();

	}
	
	/*
	@Bean
	public ColorPrinter colorPrinter(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter)
	{
		//The ColorPrinterImpl needs some dependencies. I can pass the methods as they are or I can declare
		//some objects as parameters to the colorPrinter method.
		//RedPrinter, BluePrinter and GreenPrinter Beans are created before this Bean so I can inject them here
		return new ColorPrinterImpl(redPrinter, bluePrinter, greenPrinter);
	}
	*/
}
