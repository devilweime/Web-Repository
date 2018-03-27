package com.pms.mailbag.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SimpleHttpUtils {

	public String doPostByForm(String jsonParam, String url) throws ParseException, IOException {
		String result = "";
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost doPost = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		Gson gson = new Gson();
		Map<String, String> paramMap = gson.fromJson(jsonParam, new TypeToken<Map<String, String>>() {
		}.getType());
		Set<Entry<String, String>> entrySet = paramMap.entrySet();
		for (Entry<String, String> entry : entrySet) {
			params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		UrlEncodedFormEntity se = new UrlEncodedFormEntity(params, "UTF-8");
		doPost.setEntity(se);
		HttpResponse response = httpClient.execute(doPost);
		HttpEntity entity = response.getEntity();
		result = EntityUtils.toString(entity);
		return result;
	}

	public static String doPostByJson(String jsonParam, String url) throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost doPost = new HttpPost(url);
		StringEntity se = new StringEntity(jsonParam, "UTF-8");
		se.setContentType("application/json");
		doPost.setEntity(se);
		HttpResponse response = httpClient.execute(doPost);
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity);
	}

	public static String doPostByUrl(String url) throws ParseException, IOException {
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost doPost = new HttpPost(url);
		HttpResponse response = httpClient.execute(doPost);
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity);
	}

	public static String doGettByUrl(String url) throws ParseException, IOException {
		HttpClient httpClient = HttpClients.createDefault();
		HttpGet doGet = new HttpGet(url);
		HttpResponse response = httpClient.execute(doGet);
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity);
	}

}
