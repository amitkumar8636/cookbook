/**
 * cookbook
 * Amit
 *
 */
package com.practise.cookbook.beans;

import java.util.List;

/**
 * @Project Digital Seer
 * @Author Amit
 * @Date Nov 7, 2019
 */
public class AllData {
	private long time;
	private List<LogsBean> logs;
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public List<LogsBean> getLogs() {
		return logs;
	}
	public void setLogs(List<LogsBean> logs) {
		this.logs = logs;
	}
	
	

}
