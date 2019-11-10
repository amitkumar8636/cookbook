/**
 * logger
 * Amit
 *
 */
package com.cg.logger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Project Digital Seer
 * @Author Amit
 * @Date Nov 8, 2019
 */
@RestController
@CrossOrigin("*")
public class LogController {
	private static Logger LOGGER = LoggerFactory.getLogger("My Logger application");

	@GetMapping(value = "/error1")
	public String getReport() {
		LOGGER.error("Incompatiable type");

		return "";
	}
	@GetMapping(value = "/error2")
	public String getRepor() {
		LOGGER.error("Class Cast Exception");

		return "";
	}
	@GetMapping(value = "/error3")
	public String getRepo() {
		LOGGER.error("OutOfMemoryBound");

		return "";
	}
	@GetMapping(value = "/error4")
	public String getRe() {
		LOGGER.error("ArrayIndexOutOfBound");

		return "";
	}
	@GetMapping(value = "/error5")
	public String get() {
		LOGGER.error("JDBC Connection Refused");

		return "";
	}
	@GetMapping(value = "/error6")
	public String getR() {
		LOGGER.error("Entity Not Available");

		return "";
	}
	@GetMapping(value = "/error7/{language}")
	public String getr(@PathVariable("language") String language) {
		LOGGER.error(language);

		return "";
	}
	@GetMapping(value = "/error8")
	public String getData() {
		LOGGER.error("Unexpected error found");

		return "";
	}
	@GetMapping(value = "/error9")
	public String getDataReport() {
		LOGGER.error("Runtime failure");

		return "";
	}
	@GetMapping(value = "/error10")
	public String getran() {
		LOGGER.error("NullPointerException");

		return "";
	}
	
	
}
