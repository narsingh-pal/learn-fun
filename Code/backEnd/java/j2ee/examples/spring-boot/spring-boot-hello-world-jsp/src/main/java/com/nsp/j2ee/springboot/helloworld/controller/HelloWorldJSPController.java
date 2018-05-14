package com.nsp.j2ee.springboot.helloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import org.apache.log4j.Logger;

@Controller
public class HelloWorldJSPController {
	
	final static Logger logger = Logger.getLogger(HelloWorldJSPController.class);
	
	@Value("${application.message:Hello World}")
	private String helloMessage;

	@RequestMapping("/")
	public String welcome(Map<String, String> model) {
		model.put("message", helloMessage);
		return "index";
	}

	@RequestMapping("/hello")
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		logger.info("Inside JSP controller");
		return "hello";
	}
}