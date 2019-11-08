package com.practise.cookbook.service;

import java.time.LocalDate;
import java.util.List;

import com.practise.cookbook.beans.AllData;
import com.practise.cookbook.beans.SevertyCountBean;

/**
 * 
 * @author Team1
 * @viewedBy certainSomeone
 * Service Interface ReportService
 *
 */
public interface ReportService {

	/**
	 * @param start
	 * @param endDate
	 * @return
	 */
	List<AllData> getAllData(LocalDate start, LocalDate endDate);
	/**
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<SevertyCountBean> getSeverityCount(LocalDate startDate, LocalDate endDate);
}
