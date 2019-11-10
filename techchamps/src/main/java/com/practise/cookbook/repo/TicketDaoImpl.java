/**
 * techchamps
 * Amit
 *
 */
package com.practise.cookbook.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practise.cookbook.beans.TicketBean;

/**
 * @Project Digital Seer
 * @Author Amit
 * @Date Nov 8, 2019
 */
@Repository
@Transactional
public class TicketDaoImpl {

	@PersistenceContext
	private EntityManager  em;
	
	
	public boolean updateTicket(TicketBean ticket) {
		boolean success=false;
		
		TicketBean t = em.find(TicketBean.class, ticket.getTicketId());
		t.setOpen(ticket.isOpen());
		
		
		return success;
	}

	
	public void createTicket(TicketBean ticket) {
		em.persist(ticket);
	}

	public List<TicketBean> getallTickets() {
		TypedQuery<TicketBean> q = 
		        em.createQuery("select t from TicketBean t", TicketBean.class);
		List<TicketBean> tickets = q.getResultList();
		return tickets;
	}
	

}
