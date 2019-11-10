/**
 * techchamps
 * Amit
 *
 */
package com.practise.cookbook.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practise.cookbook.beans.AllData;
import com.practise.cookbook.beans.LogsBean;
import com.practise.cookbook.beans.TicketBean;
import com.practise.cookbook.service.TicketService;

/**
 * @Project Digital Seer
 * @Author Amit
 * @Date Nov 8, 2019
 */
@CrossOrigin("*")
@RestController
public class TicketController {
	@Autowired
	private TicketService ticketService;

	@GetMapping(value = "/getTickets", produces = "application/json")
	public List<TicketBean> getAllTickets() {
		
		return ticketService.getallTickets();
	}
	
	@PostMapping(value = "/createTicket",consumes = "application/json", produces = "application/json")
	public boolean createTicket(@RequestBody LogsBean log) {
		System.out.println("1");
		if (log==null) {
			System.out.println("Post Object not found");
		}
		ticketService.createTicket(log);;
		System.out.println("2");
		return true;
	}
	
	@PostMapping(value = "/updateTicket",consumes = "application/json", produces = "application/json")
	public boolean createTicket(@RequestBody TicketBean ticket) {
		if (ticket==null) {
			System.out.println("Post Object not found");
		}
		ticketService.updateTicket(ticket);
		return true;
	}

}
