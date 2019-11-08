package com.practise.cookbook.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practise.cookbook.beans.AllData;
import com.practise.cookbook.beans.PostData;
import com.practise.cookbook.beans.SevertyCountBean;
import com.practise.cookbook.exception.ErrorMessages;
import com.practise.cookbook.exception.ProgramException;
import com.practise.cookbook.service.ReportService;

/**
 * 
 * @author Team1
 * @viewedBy certainSomeone Controller ReportController
 *
 */
@CrossOrigin("*")
@RestController
public class ReportController {

	@Autowired
	private ReportService reportService;

	/**
	 * Method getReport
	 * 
	 * @param String language
	 * @return report
	 */
	@GetMapping(value = "/report/{language}", produces = "application/json")
	public String getReport(@PathVariable("language") String language) {
		if (null == language) {
			throw new ProgramException(ErrorMessages.MESSAGE3);
		}
//		String report =reportService.getReport(language);
		return "";
	}

	@PostMapping(value = "/getalldata",consumes = "application/json", produces = "application/json")
	public List<AllData> getReport(@RequestBody PostData postdate) {
		return reportService.getAllData(postdate.getStartDate(), postdate.getEndDate());
		
	}

	@PostMapping(value = "/getalllogsCount",consumes = "application/json", produces = "application/json")
	public List<SevertyCountBean> getAllLogs(@RequestBody PostData postdate) {
		return reportService.getSeverityCount(postdate.getStartDate(), postdate.getEndDate());

	}
	
	@GetMapping(value = "/getalldata", produces = "application/json")
	public List<AllData> getGReport() {
		
		return reportService.getAllData(LocalDate.now().minusDays(7), LocalDate.now());
		
	}

	@GetMapping(value = "/getalllogsCount", produces = "application/json")
	public List<SevertyCountBean> getAllGLogs() {
		return reportService.getSeverityCount(LocalDate.now().minusDays(7), LocalDate.now());

	}

}
