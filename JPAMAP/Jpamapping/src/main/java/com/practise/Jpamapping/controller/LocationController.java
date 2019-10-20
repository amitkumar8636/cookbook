package com.practise.Jpamapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.Jpamapping.entity.Location;
import com.practise.Jpamapping.entity.Plants;
import com.practise.Jpamapping.service.DsService;

/**
 * 
 * @author Team1
 * @viewedBy certainSomeone
 * Controller ReportController
 *
 */
@CrossOrigin("*")
@RestController
public class LocationController {

	@Autowired
	private DsService reportService;

	/**
	 * Method getReport
	 * @param String language 
	 * @return report
	 */
	@GetMapping(value = "/report", produces = "application/json")
	public List<Location> getReport() {
		return reportService.getReport();
	}
	
	@GetMapping(value = "/rep", produces = "application/json")
	public List<Plants> getReport1() {
		return reportService.getB(1);
	}
	@GetMapping(value = "/vol", produces = "application/json")
	public int getReport2() {
		return reportService.getTotalVoltage();
	}
	
	

}
