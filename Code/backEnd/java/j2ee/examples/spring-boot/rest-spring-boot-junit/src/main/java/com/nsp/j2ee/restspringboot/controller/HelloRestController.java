package com.nsp.j2ee.restspringboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nsp.j2ee.restspringboot.models.Greeting;
import com.nsp.j2ee.restspringboot.services.GreetingService;

/*This code uses Spring 4’s new @RestController annotation, 
 * which marks the class as a controller where every method returns 
 * a domain object instead of a view. It’s shorthand for 
 * @Controller and @ResponseBody rolled together.*/
@RestController
public class HelloRestController {

	private final AtomicLong counter = new AtomicLong();
	private GreetingService service;

	public HelloRestController(GreetingService service) {
		this.service = service;
	}

	/*
	 * This example does not specify GET vs. PUT, POST, and so forth,
	 * because @RequestMapping maps all HTTP operations by default.
	 * Use @RequestMapping(method=GET) to narrow this mapping.
	 */
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		Greeting greeting = this.service.getGreeting(counter.incrementAndGet(), name);
		return greeting;
	}

}
