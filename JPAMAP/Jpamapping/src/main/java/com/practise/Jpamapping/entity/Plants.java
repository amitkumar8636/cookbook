package com.practise.Jpamapping.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.practise.Jpamapping.util.Util1;

@Entity

public class Plants implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int plantId;
	private String plantName;
	
	@Transient
	private String tiltAngle;
	
	private int locationId;
	
	@Transient
	private int  totalVoltage;
	

	@OneToMany
	@JoinColumn(name = "plantId",referencedColumnName = "plantId")
	private List<Building> buildings;


	
	public String getTiltAngle() {
		return tiltAngle;
	}


	public void setTiltAngle(String tiltAngle) {
		this.tiltAngle = tiltAngle;
	}


	public int getPlantId() {
		return plantId;
	}


	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}


	public String getPlantName() {
		return plantName;
	}


	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}


	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	public List<Building> getBuildings() {
		return buildings;
	}


	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}


	public int getTotalVoltage() {
		return totalVoltage;
	}


	public void setTotalVoltage(int totalVoltage) {
		this.totalVoltage = totalVoltage;
	}
	
	@PostLoad
	private void sum() {
		this.totalVoltage=buildings.stream().mapToInt(Building::getTotalVoltage).sum();
		this.tiltAngle=Util1.getPlantName(this.plantId);
	}
	
	
}
