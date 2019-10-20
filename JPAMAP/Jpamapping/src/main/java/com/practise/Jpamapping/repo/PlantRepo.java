package com.practise.Jpamapping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practise.Jpamapping.entity.Plants;

public interface PlantRepo extends JpaRepository<Plants, Integer> {
	
	@Query("Select p.plantName from Plants p where p.plantId=?1")
	public String getPlantName(int plantId);
	
	@Query("Select b from Plants b where b.locationId=?1")
	public List<Plants> getBOfA(int a);

}
