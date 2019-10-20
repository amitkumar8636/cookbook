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
@Entity
public class Building implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int buildingId;
	private int buildingName;
	
	@Transient
	private int totalVoltage;
	
	private int plantId;
	@OneToMany
	@JoinColumn(name = "buildingId",referencedColumnName = "buildingId")
	private List<Inverter> inverters;

	
	
	public int getTotalVoltage() {
		return totalVoltage;
	}

	
	public void setTotalVoltage(int totalVoltage) {
		int sum = inverters.stream().mapToInt(Inverter::getVoltage).sum();
		this.totalVoltage = sum;
	}

	public List<Inverter> getInverters() {
		return inverters;
	}

	public void setInverters(List<Inverter> inverters) {
		this.inverters = inverters;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public int getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(int buildingName) {
		this.buildingName = buildingName;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	@PostLoad
	private void sum() {
		this.totalVoltage=inverters.stream().mapToInt(Inverter::getVoltage).sum();
	}
	
}
