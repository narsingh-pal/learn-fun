package com.nsp.j2ee.restspringboot.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nsp.j2ee.restspringboot.models.Greeting;


public class GreetingServiceImplTest {
	
	GreetingService greetingService;
	Greeting greeting;
	@Before
	public void setupData() {
		this.greetingService = new GreetingServiceImpl();
		this.greeting = new Greeting();
		this.greeting.setId(1l);
		this.greeting.setContent("Hello, narsingh!");
	}

	@Test
	public void getGreetingTest() {
		Greeting greetingResult = greetingService.getGreeting(1l, "narsingh");
		assertEquals(this.greeting.getContent(), greetingResult.getContent());
	}

}
