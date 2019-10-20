package com.practise.Jpamapping.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Location implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int locationId;
	
	private String name;
	
	@OneToMany
	@JoinColumn(name = "locationId",referencedColumnName = "locationId")
	private List<Plants> plants;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Plants> getPlants() {
		return plants;
	}

	public void setPlants(List<Plants> plants) {
		this.plants = plants;
	}

	
	
}
