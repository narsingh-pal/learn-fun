package com.nsp.j2ee.restspringboot.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.nsp.j2ee.restspringboot.controller.HelloRestController;
import com.nsp.j2ee.restspringboot.models.Greeting;
import com.nsp.j2ee.restspringboot.services.GreetingService;
@WebMvcTest(HelloRestController.class)
public class HelloRestControllerWebMvcTest extends AbstractTest {

	private Greeting greetingDefault;
	private Greeting greeting;
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GreetingService service;
	
	@Before
	public void setup() {
		this.greeting = new Greeting();
		this.greeting.setId(1l);
		this.greeting.setContent("Hello, narsingh");
		this.greetingDefault = new Greeting();
		this.greetingDefault.setId(1l);
		this.greetingDefault.setContent("Hello, World");
		when(service.getGreeting(2l, "narsingh")).thenReturn(this.greeting);
		when(service.getGreeting(1l, "World")).thenReturn(this.greetingDefault);
	}

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		this.mockMvc.perform(get("/greeting?name=narsingh")).
		andDo(print()).
		andExpect(status().isOk()).
		andExpect(content().string(containsString(this.greeting.getContent())));
	}
	
	@Test
	public void greetingShouldReturnDefaultMessageFromService() throws Exception {
		this.mockMvc.perform(get("/greeting")).
		andDo(print()).
		andExpect(status().isOk()).
		andExpect(content().string(containsString(this.greetingDefault.getContent())));
	}

}
