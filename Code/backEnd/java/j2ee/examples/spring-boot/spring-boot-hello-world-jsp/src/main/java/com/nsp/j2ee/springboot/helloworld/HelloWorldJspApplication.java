package com.nsp.j2ee.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/* @SpringBootApplication annotation
 * Spring Boot provides this convenient annotation which simply wraps 
 * @Configuration, 
 * @EnableAutoConfiguration and 
 * @ComponentScan with their default attributes.*/
@SpringBootApplication
public class HelloWorldJspApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HelloWorldJspApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorldJspApplication.class, args);
    }
}