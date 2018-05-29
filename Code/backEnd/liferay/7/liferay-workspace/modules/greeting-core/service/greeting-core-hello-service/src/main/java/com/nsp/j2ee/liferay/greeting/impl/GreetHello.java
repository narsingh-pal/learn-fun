package com.nsp.j2ee.liferay.greeting.impl;

import com.nsp.j2ee.liferay.greeting.api.Greet;
import org.osgi.service.component.annotations.Component;

@Component(property = {
        "greet.hello=true",
        "service.ranking:Integer=101"
})
public class GreetHello  implements Greet{
	public String greet(String message){
		return "Hello : " + message;
	}
}