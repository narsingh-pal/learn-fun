package com.nsp.j2ee.springboot.helloworld.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController. This is known as a stereotype annotation. 
 * It provides hints for people reading the code and for Spring that the class plays a specific role. 
 * In this case, our class is a web @Controller, 
 * so Spring considers it when handling incoming web requests
 * The @RestController and @RequestMapping annotations are Spring MVC annotations. (They are not specific to Spring Boot.)
 * */

@RestController
@EnableAutoConfiguration
/*
 * @EnableAutoConfiguration. 
 * This annotation tells Spring Boot to “guess” how you want to configure Spring, 
 * based on the jar dependencies that you have added. 
 * Since spring-boot-starter-web added Tomcat and Spring MVC, the auto-configuration assumes that you are developing a web application and sets up Spring accordingly.*/
public class HelloWorldController {

	
	/*
	 * The @RequestMapping annotation provides “routing” information. 
	 * It tells Spring that any HTTP request with the / path should be mapped to the sayHello method. 
	 * The @RestController annotation tells Spring to render the resulting string directly back to the caller.
	 * */
	@RequestMapping("/")
	public String sayHello() {
		return "Hello Spring Boot Narsingh!!";
	}
}