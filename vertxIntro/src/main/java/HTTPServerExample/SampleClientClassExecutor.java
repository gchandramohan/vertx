package HTTPServerExample;

import io.vertx.core.Vertx;

/**
 * This class deploys the HTTP Client verticle
 * @author cmohan
 *
 */
public class SampleClientClassExecutor {
	
	public static void main(String args[]){
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new  VertxHttpClient());
		
		}

}
