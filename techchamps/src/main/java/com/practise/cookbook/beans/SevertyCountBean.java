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
public class SevertyCountBean {
private long date;
private List<String> severity;
private List<Integer> count;

public long getDate() {
	return date;
}
public void setDate(long date) {
	this.date = date;
}
public List<String> getSeverity() {
	return severity;
}
public void setSeverity(List<String> severity) {
	this.severity = severity;
}
public List<Integer> getCount() {
	return count;
}
public void setCount(List<Integer> count) {
	this.count = count;
}



}
