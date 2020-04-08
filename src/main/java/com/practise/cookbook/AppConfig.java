package com.practise.cookbook;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Team1
 * @viewedBy certainSomeone Bean Class AppConfig
 *
 */
@Configuration
public class AppConfig {

	/**
	 * Method getRestTemplate
	 * 
	 * @return Object RestTemplate
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		return new RestTemplate(requestFactory);
	}

//	@Bean
//	public HttpHeaders getHttpHeaders() {
//		return new HttpHeaders();
//	}

	/**
	 * Method getJsonParser
	 * 
	 * @return Parsed JSON
	 */
	@Bean
	public JSONParser getJsonParser() {
		return new JSONParser();
	}
	
	@Bean
	public JSONObject getjsonObject() {
		return new JSONObject();
	}
}
