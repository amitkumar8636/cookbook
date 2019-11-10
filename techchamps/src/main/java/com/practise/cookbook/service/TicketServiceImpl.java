/**
 * techchamps
 * Amit
 *
 */
package com.practise.cookbook.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.cookbook.CookbookApplication;
import com.practise.cookbook.beans.LogsBean;
import com.practise.cookbook.beans.TicketBean;
import com.practise.cookbook.repo.TicketDao;
import com.practise.cookbook.utils.Utils1;

/**
 * @Project Digital Seer
 * @Author Amit
 * @Date Nov 8, 2019
 */
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;
	@Override
	public boolean updateTicket(TicketBean ticket) {
		// TODO Auto-generated method stub
		TicketBean t = ticketDao.findById(ticket.getTicketId()).get();
		t.setOpen(ticket.isOpen());
		ticketDao.save(t);
		return false;
	}

	@Override
	public void createTicket(LogsBean log) {
		TicketBean tb = new TicketBean();
		tb.setAppName(log.getAppname());
		tb.setDate(Utils1.getEpochmili(LocalDate.parse(log.getDate())));
		tb.setLogMessage(log.getReason());
		tb.setOpen(true);
		tb.setSeverity(log.getSeverity());
		String sol = CookbookApplication.refData.get(log.getReason());
		tb.setSolution(sol==null?"Not Available":sol);
		ticketDao.save(tb);
	}

	@Override
	public List<TicketBean> getallTickets() {
		List<TicketBean> tickets = (List<TicketBean>) ticketDao.findAll();
		return tickets;
	}

}
