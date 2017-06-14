package VerticleDeploymentExamples;

import io.vertx.core.Future;
import io.vertx.core.Handler;

public class sampleHandler implements Handler {

	@Override
	public void handle(Object event) {
		  
			System.out.println("verticle is deployed and the evnet is  reaceived:" + event.toString());
			if(event instanceof Future)
				System.out.println("received future event");
		
	}

}
