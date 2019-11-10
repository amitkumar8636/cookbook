/**
 * cookbook
 * Amit
 *
 */
package com.practise.cookbook.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project Digital Seer
 * @Author Amit
 * @Date Nov 7, 2019
 */
public class Utils1 {
	
	public static long getEpochmili(LocalDate localDate) {
		long numberOfDays = localDate.toEpochDay();
//		System.out.println(numberOfDays);
		
		//LocalDate to epoch seconds	
//		long timeInSeconds = localDate.toEpochSecond(LocalTime.NOON, ZoneOffset.MIN);
//		System.out.println(timeInSeconds);
//		
		//LocalDate to epoch milliseconds 	
		Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();	
		long timeInMillis = instant.toEpochMilli();
//		System.out.println(" hh "+timeInMillis);
		
//		instant = localDate.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant();
//		timeInMillis = instant.toEpochMilli();
		return timeInMillis;
	}

}
