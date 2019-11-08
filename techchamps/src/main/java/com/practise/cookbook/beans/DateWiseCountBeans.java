/**
 * cookbook
 * Amit
 *
 */
package com.practise.cookbook.beans;

import java.time.LocalDate;
import java.util.List;

/**
 * @Project Digital Seer
 * @Author Amit
 * @Date Nov 7, 2019
 */
public class DateWiseCountBeans {
	private LocalDate date;
	private List<LogsBean> sbeans;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<LogsBean> getSbeans() {
		return sbeans;
	}
	public void setSbeans(List<LogsBean> sbeans) {
		this.sbeans = sbeans;
	}
	
	
	
}
