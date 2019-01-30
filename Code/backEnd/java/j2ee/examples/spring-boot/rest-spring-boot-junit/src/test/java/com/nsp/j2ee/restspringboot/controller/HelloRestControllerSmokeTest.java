package com.nsp.j2ee.restspringboot.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nsp.j2ee.restspringboot.controller.HelloRestController;

@SpringBootTest
public class HelloRestControllerSmokeTest extends AbstractTest {
	@Autowired
	private HelloRestController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
