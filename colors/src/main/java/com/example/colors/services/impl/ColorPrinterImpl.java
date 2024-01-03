package com.example.colors.services.impl;

import org.springframework.stereotype.Component;

import com.example.colors.services.BluePrinter;
import com.example.colors.services.ColorPrinter;
import com.example.colors.services.GreenPrinter;
import com.example.colors.services.RedPrinter;



/*
 * Another way of creating Beans is by using the annotation @Component or @Service
 * If I delete the PrinterConfig.java file, I can go to the concrete classes that
 * I want to create Beans and use the previous annotations
 * 
 * This annotation tells spring that the following class is a Bean, an implementation of an interface
 * and it should be put inside the application context. It also says that if the following
 * class needs some dependencies (you can see them for example as constructor's parameters)
 * inject them too. I put on comments the method that creates a Bean for ColorPrinter inside the configuration
 * file in order to see that @Component works.
 */

@Component
public class ColorPrinterImpl implements ColorPrinter
{
	
	private RedPrinter redPrinter;
	private BluePrinter bluePrinter;
	private GreenPrinter greenPrinter;
	
	/*
	 * This is not good because it does not obey the inversion of control.
	 * Let's say that I have a class and inside that class I declare some objects (using the new keyword).
	 * This class depends on some other classes (objects' classes).
	 * If I want to change that kind of objects, I need to change the outside class.
	 * There is a way to change the objects without changing the code of the outside class.
	 * If I declare some interfaces to the outside class, then I can provide the concrete classes of that implementation to the class.
	 * Spring Boot will create the concrete classes and then inject them where needed.
	 * This is good because if I want to change an object, I would tell spring to get rid of that
	 * class, create some new class that meets the interface and inject the new object where the
	 * interface type is declared.
	 * Spring Boot uses dependency injection.
	 * 
	 * Let's swap out the dependencies it uses
	 * 
	 * The concrete classes are called Beans
  	 * 
  	 * The objects that form the backbone of your application and that are managed by the Spring IoC container are called beans.
    	 *
	 * How do I create Beans? One way is with configuration file.
	 * Go to the root of the project com.example.colors and create a package and call it for example config.
	 * Inside the config package create a new class called for example PrinterConfig.
	 * This class is a configuration class and I should annotate this class with @Configuration annotation.
	 * This annotation tells Spring Boot to look at PrinterConfig class for Bean declaration.
	 * 
	 * Now inside the configuration class I will create some methods. Each method represents a Bean declaration.
	 * Do not forget to annotate each method with @Bean annotation
	 */
	
	
	public ColorPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter)
	{
		//EnglishRedPrinter, EnglishBluePrinter, EnglishGreenPrinter are also dependencies and they should be Beans
		//I will remove them and I will declare them as constructor's arguments
		//Keep in mind that you should declare the interface as a type
		//I declare them in the constructor because Spring will use the constructor
		//as a way of identifying which dependencies are needed in order to inject them
		
		/*
		this.redPrinter = new EnglishRedPrinter();
		this.bluePrinter = new EnglishBluePrinter();
		this.greenPrinter = new EnglishGreenPrinter();
		*/
		
		this.redPrinter = redPrinter;
		this.bluePrinter = bluePrinter;
		this.greenPrinter = greenPrinter;
	}



	@Override
	public String print() 
	{
		return String.join(",", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
	}

}
