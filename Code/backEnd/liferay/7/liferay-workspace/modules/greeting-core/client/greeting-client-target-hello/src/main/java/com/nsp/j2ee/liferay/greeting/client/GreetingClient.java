package com.nsp.j2ee.liferay.greeting.client;

import com.nsp.j2ee.liferay.greeting.api.Greet;
/*import org.apache.felix.service.command.CommandProcessor;*/
/*import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;*/
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class GreetingClient {
	private static final Logger logger = LoggerFactory.getLogger(GreetingClient.class);
    private Greet greet;

    @Reference(target = "(greet.hello=true)")
    public void setGreeting(Greet greet) {
        this.greet = greet;
    }


    @Activate
    public void  greet(){
        logger.info(greet.greet("Narsingh - Target Demo"));
    }

    @Deactivate
    public void  deactivate(){
        logger.info("GreetingClient Bundle Stopped : Reason : greeting hello bundle stopped");
    }
}