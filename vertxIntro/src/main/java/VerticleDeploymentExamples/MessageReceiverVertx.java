package VerticleDeploymentExamples;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MessageReceiverVertx  extends AbstractVerticle{
	
	@Override
	  public void start(Future<Void> startFuture) throws Exception {
	   
		
		   //vertx.eventBus().consumer("Message", new sampleHandler());
	    vertx.eventBus().consumer("EventBusMessage", message -> {
            System.out.println("1 received message.body() = "
                + message.body());
        });
	  }
	
	

}
