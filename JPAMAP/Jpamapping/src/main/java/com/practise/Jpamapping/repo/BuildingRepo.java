package com.practise.Jpamapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practise.Jpamapping.entity.Inverter;

public interface BuildingRepo extends JpaRepository<Inverter, Integer> {
	
	@Query("Select Sum(i.voltage) from Inverter i where i.buildingId=?1")
	public String getTotalVoltage(int buidingId);
	
	@Query("Select Sum(i.voltage) from Inverter i where i.buildingId=?1")
	public String getCurrent(int plantId);
}
