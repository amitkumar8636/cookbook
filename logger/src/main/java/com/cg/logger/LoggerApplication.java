package com.cg.logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggerApplication {
	private static Logger LOGGER = LoggerFactory.getLogger("My Logger application");
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(LoggerApplication.class, args);
		int r=0;
		while(true) {
			r++;
			if (r%7==0) {
				LOGGER.error("Incompatiable type");
			}
			else if (r%3==0) {
				LOGGER.warn("Max Connectional reached");
				
			}
			else if (r%2==0) {
				LOGGER.info("Application access the database");
			}
			else {
				LOGGER.debug("Application is running smoothly");
			}
			LOGGER.trace(Thread.currentThread().getName());
	
		Thread.currentThread();
		Thread.sleep(5000);
		
		}
	}

}
