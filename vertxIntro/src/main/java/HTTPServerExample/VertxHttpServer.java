package HTTPServerExample;



import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

/**
 * This class creates an http server and listens in the port 9999.
 * if any request receives(eihter through browser or through vertx HTTP client, then this class sends a sample response.
 * @author cmohan
 *
 */

public class VertxHttpServer extends AbstractVerticle{
	/*
	@Override
	  public void start(Future<Void> startFuture) throws Exception {
		HttpServer httpServer = vertx.createHttpServer().requestHandler( r -> {
			r.response().end("request is received");
		}).listen(8080, r -> {
			if(r.succeeded()){
				startFuture.complete();
			}else{
				startFuture.failed();
			}
				
		});
		
	}*/
	
	private HttpServer httpServer = null;

    @Override
    public void start() throws Exception {
    	
        httpServer = vertx.createHttpServer();
        httpServer.requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest request) {
            	HttpServerResponse response = request.response();
            	response.setStatusCode(200);
            	response.headers()
            	    .add("Content-Length", String.valueOf(157))
            	    .add("Content-Type", "text/html")
            	;
            	response.write("first response \n ");
            	response.write("second response \n");
            	
            	response.end("Final Response");
            	
                
                
            }
        });

        httpServer.listen(9999);
        
    }
}
