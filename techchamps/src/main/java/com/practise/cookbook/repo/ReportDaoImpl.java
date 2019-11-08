package com.practise.cookbook.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import com.practise.cookbook.beans.AllData;
import com.practise.cookbook.beans.Login;
import com.practise.cookbook.beans.LogsBean;
import com.practise.cookbook.beans.SevertyCountBean;
import com.practise.cookbook.exception.ErrorMessages;
import com.practise.cookbook.exception.ProgramException;
import com.practise.cookbook.utils.Utils1;

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
	List<LogsBean> logbeans = null;


	@Override
	public List<AllData> getAllData(LocalDate start, LocalDate endDate) {
		LocalDate temp=start;
		List<AllData> dataList = new ArrayList<AllData>();
		while(temp.isBefore(endDate)) {
//			LocalDate date = endDate.minusDays(i);
			AllData a1 = new AllData();
			a1.setTime(Utils1.getEpochmili(temp));
			
			final String url = "https://search-tech-champs-domain-ft4hwirv2uprpp4anl2ppkscim.us-east-1.es.amazonaws.com/myapp/_search?q=date:\""
					+ temp + "\"&size=2000";
			List<LogsBean> logbeans = makeApiRequest(url);
			a1.setLogs(logbeans);
			dataList.add(a1);
			temp = temp.plusDays(1);
		}
		return dataList;
	}
	

	private List<LogsBean> makeApiRequest(String url) {

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
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(login); // use jsonString.toString() inplace of loginJSONObject
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		HttpEntity<String> request = new HttpEntity<String>(jsonString.toString(), headers);

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		try {
			jsonObject = (JSONObject) parser.parse(response.getBody());
		} catch (ParseException e) {
			throw new ProgramException(ErrorMessages.MESSAGE2);
		}
		JSONObject res = ((JSONObject) jsonObject.get("hits"));
		List<Object> hits = (List<Object>) res.get("hits");
		logbeans = new ArrayList<LogsBean>();
		for (int i = 0; i < hits.size(); i++) {
			JSONObject logdata = (JSONObject) ((JSONObject) hits.get(i)).get("_source");
			LogsBean lb = new LogsBean();
			lb.setAppname(logdata.get("appname").toString());
			lb.setDate(logdata.get("date").toString());
			lb.setReason(logdata.get("reason").toString());
			lb.setSeverity(logdata.get("severity").toString());
			lb.setTime(logdata.get("time").toString());
			lb.setTimestamp(Utils1.getEpochmili(LocalDate.parse(lb.getDate())));
			System.out.println();
//			lb.setTimestamp(Long.valueOf((logdata.get("timestamp").toString()).substring(0,10)));
			logbeans.add(lb);
			System.out.println(lb.getTimestamp());

		}

		return logbeans;
	}

	@Override
	public List<SevertyCountBean> getSeverityCount(LocalDate startDate, LocalDate endDate) {
		List<SevertyCountBean> sblist= new ArrayList<>();
//		SevertyCountBean sb = new SevertyCountBean();
//		List<Integer> counts = new ArrayList<>();
//		List<String> severities = new ArrayList<>();
		String ss[] = { "INFO", "DEBUG", "WARN", "ERROR", "FATAL" };
		LocalDate temp = startDate;
		while (temp.isBefore(endDate)) {
			List<LogsBean> lbeans = makeApiRequest(
					"https://search-tech-champs-domain-ft4hwirv2uprpp4anl2ppkscim.us-east-1.es.amazonaws.com/myapp/_search?q=date:\""
							+ temp + "\"&size=2000");
			SevertyCountBean sb = new SevertyCountBean();
			sb.setDate(Utils1.getEpochmili(temp));
			
			List<Integer> counts = new ArrayList<>();
			List<String> severities = new ArrayList<>();
			
			for (int i = 0; i < ss.length; i++) {
				String a= ss[i];
				counts.add((int) logbeans.stream().filter(o -> o.getSeverity().equals(a)).count());
				severities.add(ss[i]);
			}
			sb.setCount(counts);
			sb.setSeverity(severities);
			sblist.add(sb);
			temp=temp.plusDays(1);
			
		}
		return sblist;
	}

}
