package com.practise.cookbook;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CookbookApplication {
	public static Map<String, String> refData = new HashMap<>();
	public static void main(String[] args) {
		refData.put(" Incompatiable type\n","Check your variable type" );
		refData.put(" Max Connectional reached\n","Increase your database connection pool size");
		refData.put(" Access violated\n", "User is no longer authorize!");
		refData.put(" Class Cast Exception\n", "Use Generics to prevent ClassCastException or Try with Type Casting");
		refData.put(" OutOfMemoryBound\n", "Restart your Application");
		refData.put(" ArrayIndexOutOfBound\n", "Use index is either less than or equal to the size of the array.");
		refData.put(" JDBC Connection Refused\n", "Check the database Configuration and status");
		refData.put(" Entity Not Available\n", "Check your bean container that might get fail to instantiate the bean");
		refData.put(" Unexpected error found\n", "No Solution available");
		refData.put(" NullPointerException\n", "Check while Calling the instance method,Accessing,modifying the field of a object.");
		refData.put(" Runtime failure\n", " Check your application logs and Restart your application");

		


		
		SpringApplication.run(CookbookApplication.class, args);
	}

}
