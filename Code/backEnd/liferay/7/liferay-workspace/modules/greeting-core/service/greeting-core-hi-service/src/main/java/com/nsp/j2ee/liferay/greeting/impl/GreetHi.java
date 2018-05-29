package com.nsp.j2ee.liferay.greeting.impl;

import com.nsp.j2ee.liferay.greeting.api.Greet;
import org.osgi.service.component.annotations.Component;

@Component(property = {
        "greet.hi=true",
        "service.ranking:Integer=100"
})
public class GreetHi  implements Greet{
	public String greet(String message){
		return "Hi : " + message;
	}
}