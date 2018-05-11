package com.nsp.j2ee.usermanagement.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nsp.j2ee.application.config.AppConfiguration;
import com.nsp.j2ee.usermanagement.application.UserDetailApplication;



public class TestApplication {

	public static void main(String[] args) {
		// Load the Spring context and beans
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		UserDetailApplication userDetailApp = context.getBean(UserDetailApplication.class);
		userDetailApp.performDbTasks();
		context.close();
	}
}