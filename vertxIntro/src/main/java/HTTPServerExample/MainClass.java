package HTTPServerExample;

import io.vertx.core.Vertx;

/**
 * This class deploys the HTTP Server verticle
 * @author cmohan
 *
 */
public class MainClass {
	
	public static void main(String args[]){
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new  VertxHttpServer());
		
		
		}

}
