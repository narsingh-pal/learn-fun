package com.nsp.j2ee.restspringboot.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloRestControllerSpringBootTest extends AbstractTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting", String.class))
				.contains("Hello, World");
	}
	
	@Test
	public void greetingShouldReturnDefaultName() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting?name=narsingh", String.class))
				.contains("Hello, narsingh");
	}
	
	
}
