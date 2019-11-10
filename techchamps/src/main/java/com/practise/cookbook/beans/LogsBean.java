/**
 * cookbook
 * Amit
 *
 */
package com.practise.cookbook.beans;

import java.time.LocalDate;

/**
 * @Project Digital Seer
 * @Author Amit
 * @Date Nov 7, 2019
 */
public class LogsBean {

	private String date;
	private String time;
	private long timestamp;
	private String severity;
	private String appname;
	private String reason;
	private String solution;
	
	
	
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}



	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
