package com.nsp.j2ee.springmvc.rest.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = "com.nsp.j2ee")
public class ApplicationConfiguration {
}