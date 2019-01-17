package com.nsp.j2ee.liferay.greeting.client.configurable.impl;

import com.nsp.j2ee.liferay.greeting.client.configurable.api.GreetingConfigurator;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;

@Component(immediate = true,
        property = {
                "greeting.configurator=true"
        }
        )
public class GreetingConfiguratorImpl implements GreetingConfigurator, ManagedService {
	private static final Logger logger = LoggerFactory.getLogger(GreetingConfiguratorImpl.class);
    private String greetPerson;

    @Override
    public String getGreetPerson(){
        return this.greetPerson;
    }

    @Override
    public void updated(Dictionary properties) throws ConfigurationException {
        if( properties != null ) {
            this.greetPerson = properties.get( "greetPerson" ).toString();
            logger.info( "Greet Person = " + this.greetPerson);
        }
    }
}