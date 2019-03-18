package lab6_client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

public class cleint {
public static void main(String[] args) {
	CloseableHttpResponse response = null;
	CloseableHttpResponse httpClient = null;
	
	try {
		
		URI  uri = new URIBuilder().setScheme("http").setHost("locallhost")
				.setPort(8080).setPath("/Book2/rest/books").build();
		
		System.out.println(uri.toString());
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Accept","text/html");
		
		httpClient = HttpClients.createDefault();
		response = httpClient.execute(httpGet);
		
		String text;
		try{
			HttpEntity entity = response.getEntity();
			text = getASCIIContentFromEntity(entity);
			
		}
		finally {
			response.close();
			}
		System.out.println("Reply :"+text);
		
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
static String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException 
{ 
	InputStream in = entity.getContent(); 
	StringBuffer out = new StringBuffer(); 
	int n = 1; 
	while (n > 0) 
	{ 
		byte[] b = new byte[4096]; 
		n = in.read(b); 
		if (n > 0) 
			out.append(new String(b, 0, n)); 
	} 
	return out.toString(); 
}
}
