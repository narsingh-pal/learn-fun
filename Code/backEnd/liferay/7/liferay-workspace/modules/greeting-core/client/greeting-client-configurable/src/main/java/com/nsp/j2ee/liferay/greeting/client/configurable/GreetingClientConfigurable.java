package com.nsp.j2ee.liferay.greeting.client.configurable;

import com.nsp.j2ee.liferay.greeting.api.Greet;
import com.nsp.j2ee.liferay.greeting.client.configurable.api.GreetingConfigurator;
import org.osgi.service.component.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class GreetingClientConfigurable {
	private static final Logger logger = LoggerFactory.getLogger(GreetingClientConfigurable.class);
    private Greet greet;
    @Reference
    public void setGreeting(Greet greet) {
        this.greet = greet;
    }

    @Reference(target="(greeting.configurator=true)")
    GreetingConfigurator greetingConfigurator;

    @Activate
    @Modified
    public void  greet(){
        logger.info(greet.greet(greetingConfigurator.getGreetPerson()));
        logger.info("GreetingClientConfigurable :::  Bundle started");
    }

    @Deactivate
    public void  deactivate(){
        logger.info("GreetingClientConfigurable :::  Bundle Stopped");
    }
}