package com.nsp.j2ee.liferay.greeting.client;

/*import aQute.bnd.annotation.component.Activate;*/
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
/*@Component(
        service=Greet.class
)*/
/*@Component(properties =	{
        *//* Felix GoGo Shell Commands *//*
        CommandProcessor.COMMAND_SCOPE + ":String=example",
        CommandProcessor.COMMAND_FUNCTION + ":String=greet"},
        provide = Object.class
)*/
@Component
public class GreetingClient {
	private static final Logger logger = LoggerFactory.getLogger(GreetingClient.class);
    private Greet greet;

    @Reference
    public void setGreeting(Greet greet) {
        this.greet = greet;
    }


	/*@Activate
	public void  greet(String message){
		logger.info(greet.greet(message));
	}*/

    @Activate
    public void  greet(){
        logger.info(greet.greet("Narsingh"));
    }


    @Deactivate
    public void  deactivate(){
        logger.info("Bundle Stopped");
    }
}