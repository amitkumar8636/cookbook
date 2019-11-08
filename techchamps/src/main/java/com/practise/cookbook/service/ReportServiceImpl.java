package com.practise.cookbook.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.cookbook.beans.AllData;
import com.practise.cookbook.beans.SevertyCountBean;
import com.practise.cookbook.repo.ReportDao;

/**
 * 
 * @author Team1
 * @viewedBy certainSomeone
 * Service Implementation ReportServiceImpl
 */
@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao reportdao;

	/**
	 * Method getReport of ServiceImpl
	 * @param takes String language
	 * Returns Object report 
	 */
	@Override
	public List<AllData> getAllData(LocalDate start,LocalDate endDate) {
		return reportdao.getAllData(start, endDate);
	}
	
	@Override
	public 	List<SevertyCountBean> getSeverityCount(LocalDate startDate,LocalDate endDate){
		return reportdao.getSeverityCount(startDate,endDate);
	}
}
	