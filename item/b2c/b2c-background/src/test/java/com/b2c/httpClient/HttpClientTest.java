package com.b2c.httpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {

	@Test
	public void test01() throws URISyntaxException, ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		URIBuilder uriBuilder = new URIBuilder("http://www.baidu.com");
		URI uri = uriBuilder.build();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = httpClient.execute(httpGet);
		int code = response.getStatusLine().getStatusCode();
		if (code == 200) {
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, "utf-8");
			System.out.println(result);
		}
	}


	public static String test02(String uriStr,Map<String, String> param) {
		String result="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			URIBuilder builder = new URIBuilder(uriStr);
			if(param!=null && !param.isEmpty()){
				Set<String> keySet = param.keySet();
				Iterator<String> it = keySet.iterator();
				while (it.hasNext()) {
					String key = (String) it.next();
					builder.addParameter(key,param.get(key));
				}
			}
			URI uri = builder.build();
			HttpGet httpGet = new HttpGet(uri);
			
			try {
				CloseableHttpResponse response = httpClient.execute(httpGet);
				int code = response.getStatusLine().getStatusCode();
				if(code==200){
				 result = EntityUtils.toString(response.getEntity(), "utf-8");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("username", "kebi");
		String string = test02("http://localhost:8080/b2c-background/page/httpClient", map);
		System.out.println(string);
	}

}
