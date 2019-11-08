package com.practise.cookbook.repo;

import java.time.LocalDate;
import java.util.List;

import com.practise.cookbook.beans.AllData;
import com.practise.cookbook.beans.SevertyCountBean;

/**
 * 
 * @author Amit Kumar
 * Dao Interface ReportDao
 *
 */
public interface ReportDao {


	
	List<SevertyCountBean> getSeverityCount(LocalDate startDate,  LocalDate endDate);

	/**
	 * @param start
	 * @param endDate
	 * @return
	 */
	List<AllData> getAllData(LocalDate start, LocalDate endDate);

	

}
