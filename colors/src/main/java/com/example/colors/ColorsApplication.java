package com.example.colors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.colors.services.ColorPrinter;

//SpringBootApplication annotation declares the starting point for component scanning. Spring will scan all the packages starting from here (I mean starting from the folder that contains the class that is annotated). 
//If I have the Beans to some place that is not in this tree hierarchy, then Spring will not find the Beans that are needed for the app.

@SpringBootApplication
public class ColorsApplication implements CommandLineRunner
{

	private ColorPrinter colorPrinter;
	
	//Now that I have a ColorPrinter Bean created, Spring will inject it
	public ColorsApplication(ColorPrinter colorPrinter)
	{
		this.colorPrinter = colorPrinter;
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(ColorsApplication.class, args);
	}

	@Override
	public void run(String... args)
	{
		/*This ColorPrinterImpl constructor now needs the dependencies. The best solution is to use injection.
		 *final ColorPrinter colorPrinter = new ColorPrinterImpl(); //this class depends on ColorPrinterImpl. I can create a Bean for the ColorPrinterImpl
		 *System.out.println(colorPrinter.print());
		 */
		
		System.out.println(colorPrinter.print());
		
	}

}
