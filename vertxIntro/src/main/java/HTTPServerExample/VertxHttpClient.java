package HTTPServerExample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientResponse;

public class VertxHttpClient  extends AbstractVerticle{
	
	@Override
	public void start() throws Exception{
		HttpClient  httpClient = vertx.createHttpClient();
		/*httpClient.getNow(9999, "localhost", "/", new Handler<HttpClientResponse>() {

		    @Override
		    public void handle(HttpClientResponse httpClientResponse) {
		        System.out.println("Response received :" + httpClientResponse.statusCode());
		    }
		});
		*/
		httpClient.getNow(9999, "localhost", "/", new Handler<HttpClientResponse>() {

		    @Override
		    public void handle(HttpClientResponse httpClientResponse) {
		    	System.out.println("Response received :" + httpClientResponse.statusCode());
		    	
		        httpClientResponse.bodyHandler(new Handler<Buffer>() {
		            @Override
		            public void handle(Buffer buffer) {
		                System.out.println("Response (" + buffer.length() + "): ");
		                System.out.println(buffer.getString(0, buffer.length()));
		            }
		        });
		    }
		});
		
	}
	
	

}
