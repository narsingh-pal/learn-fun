package com.nsp.j2ee.restspringboot.services;

import com.nsp.j2ee.restspringboot.models.Greeting;

public interface GreetingService {

	Greeting getGreeting(long id, String name);
}
