/**
 * techchamps
 * Amit
 *
 */
package com.practise.cookbook.service;

import java.util.List;

import com.practise.cookbook.beans.LogsBean;
import com.practise.cookbook.beans.TicketBean;

/**
 * @Project Digital Seer
 * @Author Amit
 * @Date Nov 8, 2019
 */
public interface TicketService {
boolean updateTicket(TicketBean log);
void createTicket(LogsBean ticket);
List<TicketBean> getallTickets();


}
