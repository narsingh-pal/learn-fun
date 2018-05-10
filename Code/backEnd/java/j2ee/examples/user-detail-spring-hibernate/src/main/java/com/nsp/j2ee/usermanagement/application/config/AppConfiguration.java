package com.nsp.j2ee.usermanagement.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



/*The @ComponentScan annotation is used with the @Configuration annotation to tell 
 * Spring the packages to scan for annotated components. 
 * @ComponentScan also used to specify base packages and base package classes using 
 * thebasePackageClasses or basePackages attributes of @ComponentScan.
The basePackageClasses attribute is a type-safe alternative to basePackages. 
When you specify basePackageClasses, Spring will scan the package (and subpackages) 
of the classes you specify. */

@Configuration
@ComponentScan(value={"com.nsp.j2ee.*"})
public class AppConfiguration {
	
	
}