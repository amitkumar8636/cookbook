package com.practise.Jpamapping.service;

import java.util.List;

import com.practise.Jpamapping.entity.Location;
import com.practise.Jpamapping.entity.Plants;

/**
 * 
 * @author Team1
 * @viewedBy certainSomeone
 * Service Interface ReportService
 *
 */
public interface DsService {

	public List<Location> getReport();
	public List<Plants> getB(int a1);
	public int getTotalVoltage();

}
