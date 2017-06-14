package VerticleDeploymentExamples;

import javax.annotation.Generated;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class SampleVerticle extends AbstractVerticle {

	public void start() throws Exception {
		System.out.println("verticle started");
		System.out.println("deplyment id = " + deploymentID());
		System.out.println("configuration: " + config().toString());
		
	}
	
	@Override
	 public void init(Vertx vertx, Context context) {
	    this.vertx = vertx;
	    this.context = context;
	   /* System.out.println("Init is executed");
	    System.out.println("deplyment id in init = " + deploymentID());

	    System.out.println("multi thread conetxt :" + this.context.isMultiThreadedWorkerContext());
	    System.out.println("event loop conetxt :" + this.context.isEventLoopContext());
	    System.out.println("worker thread conetxt :" + this.context.isWorkerContext());*/
	    
	    
	    
	  }
	
	@Override
	  public void start(Future<Void> startFuture) throws Exception {
		
	    start();
	    System.out.println("start future - " + startFuture.toString());
	    
	    this.getVertx().eventBus().send("EventBusMessage", "First Message on the event bus");
	    
	    Context context = vertx.getOrCreateContext();
	    if (context.isEventLoopContext()) {
	      System.out.println("Context attached to Event Loop");
	    } else if (context.isWorkerContext()) {
	      System.out.println("Context attached to Worker Thread");
	    } else if (context.isMultiThreadedWorkerContext()) {
	      System.out.println("Context attached to Worker Thread - multi threaded worker");
	    } else if (! Context.isOnVertxThread()) {
	      System.out.println("Context not attached to a thread managed by vert.x");
	    }
	    
	    startFuture.complete();
	  }

	  
	  @Override
	  public void stop(Future<Void> stopFuture) throws Exception {
	    stop();
	    System.out.println("stop  future - " + stopFuture.toString());
	    stopFuture.complete();
	  }

	
	public void stop() throws Exception {
		System.out.println("verticle stopped");
	}
	
	

}
