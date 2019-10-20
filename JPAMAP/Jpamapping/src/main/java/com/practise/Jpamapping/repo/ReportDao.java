package com.practise.Jpamapping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practise.Jpamapping.entity.Location;


/**
 * 
 * @Project Digital
 * @Author Amit
 * @Date Oct 20, 2019
 */
@Repository
public interface ReportDao extends JpaRepository<Location, Long> {

	@Query("Select a from Location a")
	public List<Location> getBugs();

}
