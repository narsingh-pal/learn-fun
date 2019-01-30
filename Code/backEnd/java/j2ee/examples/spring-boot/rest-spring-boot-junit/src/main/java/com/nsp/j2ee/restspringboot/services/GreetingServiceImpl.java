package com.nsp.j2ee.restspringboot.services;

import org.springframework.stereotype.Service;

import com.nsp.j2ee.restspringboot.models.Greeting;

@Service
public class GreetingServiceImpl implements GreetingService {
	private static final String template = "Hello, %s!";
	@Override
	public Greeting getGreeting(long id, String name) {
		Greeting greeting = new Greeting();
    	greeting.setId(id);
    	greeting.setContent(String.format(template, name));
		return greeting;
	}
}
