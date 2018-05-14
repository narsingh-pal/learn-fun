package com.nsp.j2ee.springboot.user.application;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nsp.j2ee.springboot.user.application.controller.UserController;

import org.springframework.context.ApplicationContext;


/*
 * The @SpringBootApplication annotation is often placed on your main class, 
 * and it implicitly defines a base “search package�? for certain items. 
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
@ComponentScan("com.nsp.j2ee")
public class UserApplication {

	public static final Logger logger = Logger.getLogger(UserApplication.class);

	/*
	 * main method. 
	 * This is just a standard method that follows the Java convention for an application 
	 * entry point. Our main method delegates to Spring Boot’s SpringApplication class 
	 * by calling run. 
	 * SpringApplication bootstraps our application, 
	 * starting Spring, which, in turn, starts the auto-configured Tomcat web server. 
	 * We need to pass UserApplication.class as an argument to the run method 
	 * to tell SpringApplication which is the primary Spring component. 
	 * The args array is also passed through to expose any command-line arguments.
	 * */
	public static void main(String[] args) {
		//SpringApplication.run(UserApplication.class, args);
		ApplicationContext applicationContext =
	            SpringApplication.run(UserApplication.class, args);
		/*for (String name: applicationContext.getBeanDefinitionNames()) {
            logger.info(name);
        }*/
	}
}
