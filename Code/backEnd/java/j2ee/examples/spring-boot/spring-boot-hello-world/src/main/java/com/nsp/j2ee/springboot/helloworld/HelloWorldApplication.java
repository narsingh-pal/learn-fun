package com.nsp.j2ee.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * The @SpringBootApplication annotation is often placed on your main class, 
 * and it implicitly defines a base “search package” for certain items. 
 * For example, if you are writing a JPA application, 
 * the package of the @SpringBootApplication annotated class is used to search for
 *  @Entity items. Using a root package also allows component scan to apply only on 
 *  your project.
 *  
 *  If you don’t want to use @SpringBootApplication, 
 *  the @EnableAutoConfiguration and @ComponentScan annotations 
 *  that it imports defines that behaviour so you can also use that instead.
 *  
 *  The @SpringBootApplication annotation is equivalent to using 
 *  @Configuration, 
 *  @EnableAutoConfiguration, and 
 *  @ComponentScan 
 *  with their default attributes
 *  */

@SpringBootApplication
public class HelloWorldApplication {

	/*
	 * main method. 
	 * This is just a standard method that follows the Java convention for an application 
	 * entry point. Our main method delegates to Spring Boot’s SpringApplication class 
	 * by calling run. 
	 * SpringApplication bootstraps our application, 
	 * starting Spring, which, in turn, starts the auto-configured Tomcat web server. 
	 * We need to pass HelloWorldApplication.class as an argument to the run method 
	 * to tell SpringApplication which is the primary Spring component. 
	 * The args array is also passed through to expose any command-line arguments.
	 * */
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
