package com.practise.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.cookbook.service.repo.ReportDao;

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
	public String getReport() {
		return reportdao.getBugs();
	}
}
	