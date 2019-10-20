package com.practise.Jpamapping.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.practise.Jpamapping.repo.BuildingRepo;
import com.practise.Jpamapping.repo.PlantRepo;
import com.practise.Jpamapping.service.DsService;

@Component
public class Util1 {
	

	private static PlantRepo buildingRepo;
	
	@Autowired
	private PlantRepo r;
	
	@PostConstruct
	public void init() {
		this.buildingRepo=r;
	}
	
	
	
	public static  String getPlantName( int plantId) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		String res="";
		if (buildingRepo==null) {
			System.out.println("SORRYYYYYYYYYYYYYY");
		}
		else {
		 res = 	buildingRepo.getPlantName(plantId);
		}
		return res+"AMIT";
	}

}
