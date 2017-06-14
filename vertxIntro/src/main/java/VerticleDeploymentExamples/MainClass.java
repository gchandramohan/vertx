package VerticleDeploymentExamples;

import java.util.Iterator;
import java.util.Set;

import io.vertx.core.Vertx;

public class MainClass {
	
	 public static void main(String[] args) {
	        Vertx vertx = Vertx.vertx();
	        vertx.deployVerticle(new MessageReceiverVertx());
	        vertx.deployVerticle(new MessageReceiverVertx());
	        
	        vertx.deployVerticle(new SampleVerticle());
	        
	        Set ids = vertx.deploymentIDs();
	        
	        
	       /* if(ids == null || ids.isEmpty()){
	        	System.out.println("no ids");
	        }
	        
	        Iterator it = ids.iterator();
	        while(it.hasNext()){
	        	String id = (String)it.next();
	        	System.out.println(" id  -" + id);
	        	vertx.undeploy(id);
	        }*/
	        
	        
	        
	    }
	
	 

}
