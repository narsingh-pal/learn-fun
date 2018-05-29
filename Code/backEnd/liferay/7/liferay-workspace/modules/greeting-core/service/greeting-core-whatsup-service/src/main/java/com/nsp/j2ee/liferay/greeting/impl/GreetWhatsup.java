package com.nsp.j2ee.liferay.greeting.impl;

import com.nsp.j2ee.liferay.greeting.api.Greet;
import org.osgi.service.component.annotations.Component;

@Component(property = {
        "greet.whatsup=true",
})
public class GreetWhatsup  implements Greet{
	public String greet(String message){
		return "Whatsup : " + message;
	}
}