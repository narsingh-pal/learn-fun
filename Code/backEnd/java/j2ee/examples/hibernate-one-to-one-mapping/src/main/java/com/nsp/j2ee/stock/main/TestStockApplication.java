package com.nsp.j2ee.stock.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nsp.j2ee.application.config.AppConfiguration;
import com.nsp.j2ee.stock.application.StockApplication;



public class TestStockApplication {

	public static void main(String[] args) {
		// Load the Spring context and beans
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		StockApplication stockApp = context.getBean(StockApplication.class);
		stockApp.performDbTasks();
		context.close();
	}
}