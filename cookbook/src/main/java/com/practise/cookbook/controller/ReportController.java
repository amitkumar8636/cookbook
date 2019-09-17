package com.practise.cookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practise.cookbook.service.ReportService;
import com.practise.cookbook.service.exception.ErrorMessages;
import com.practise.cookbook.service.exception.ProgramException;

/**
 * 
 * @author Team1
 * @viewedBy certainSomeone
 * Controller ReportController
 *
 */
@CrossOrigin("*")
@RestController
public class ReportController {

	@Autowired
	private ReportService reportService;

	/**
	 * Method getReport
	 * @param String language 
	 * @return report
	 */
	@GetMapping(value = "/report/{language}", produces = "application/json")
	public String getReport(@PathVariable("language") String language) {
		if (null==language) {
			throw new ProgramException(ErrorMessages.MESSAGE3);
		}
//		String report =reportService.getReport(language);
		return "";
	}
	
	@GetMapping(value = "/login", produces = "application/json")
	public String getReport() {
		String result =reportService.getReport();
		return result;
	}

}
