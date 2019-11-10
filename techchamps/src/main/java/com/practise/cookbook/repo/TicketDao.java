/**
 * techchamps
 * Amit
 *
 */
package com.practise.cookbook.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practise.cookbook.beans.TicketBean;

/**
 * @Project Digital Seer
 * @Author Amit
 * @Date Nov 8, 2019
 */
public interface TicketDao extends CrudRepository<TicketBean, Integer> {
		
	
}
