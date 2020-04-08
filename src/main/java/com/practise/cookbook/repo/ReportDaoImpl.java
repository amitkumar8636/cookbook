package com.practise.cookbook.repo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practise.cookbook.beans.Login;
import com.practise.cookbook.exception.ErrorMessages;
import com.practise.cookbook.exception.ProgramException;

/**
 * 
 * @author Amit Kumar
 * @viewedBy certainSomeone Dao Impl ReportDaoImpl
 *
 */
@Repository
public class ReportDaoImpl implements ReportDao {

//	private String serverUrl = "http://10.236.246.25:9000/";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private JSONObject jsonObject;

	@Autowired
	private JSONParser parser;

	@Override
	public String getBugs() {
		final String url = "https://reqres.in/api/login";
		final String res = makeApiRequest(url);

		return res;
	}

	private String makeApiRequest(String url) {
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    /**
	     * Method 1 by json object
	     */
	    JSONObject loginJSONobject = new JSONObject();
	    loginJSONobject.put("email", "eve.holt@reqres.in");
	    loginJSONobject.put("password", "cityslicka");
	    
	    /**
	     * Method 2 using object as parameter
	     */
	    Login login = new Login();
	    login.setEmail("eve.holt@reqres.in");
	    login.setPassword("cityslicka");
	    
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonString=null;
	    try {
			jsonString  = mapper.writeValueAsString(login); //use jsonString.toString() inplace of loginJSONObject
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
	    
	    
	    
	    HttpEntity<String> request = new HttpEntity<String>(jsonString.toString(), headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(url,request, String.class);
		try {
			jsonObject = (JSONObject) parser.parse(response.getBody());
		} catch (ParseException e) {
			throw new ProgramException(ErrorMessages.MESSAGE2);
		}
		String res = jsonObject.get("token").toString();
		return res;
	}

}
