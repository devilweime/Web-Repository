package com.b2c.commons.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {

	public static HttpClientUtils getInstance(){
		return new HttpClientUtils();
	}
	
	public String doGet(String uriStr,Map<String, String> param) {
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
	
	public String doGet(String uriStr){
		return doGet(uriStr,null);
	}
	
	
	public String doPost(String uri,String json){
		String result ="";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(uri);
		StringEntity entity = new StringEntity(json,ContentType.APPLICATION_JSON);
		httpPost.setEntity(entity);
		try {
			CloseableHttpResponse response = httpClient.execute(httpPost);
			result = EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String doPost(String uri){
		return doPost(uri, null);
	}
}
