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
@Configuration : Tags the class as a source of bean definitions for the application context. 

@EnableAutoConfiguration : Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
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
