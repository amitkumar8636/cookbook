
package com.practise.Jpamapping.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
@Entity
@IdClass(Cid.class)
public class Inverter implements Serializable {
	@Id
	private int timestamp;
	@Id
	private int inverterId;
	
	private int buildingId;

	private int voltage;
	
	
	private int current;


	public int getBuildingId() {
		return buildingId;
	}


	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}


	public int getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}


	public int getInverterId() {
		return inverterId;
	}


	public void setInverterId(int inverterId) {
		this.inverterId = inverterId;
	}


	public int getVoltage() {
		return voltage;
	}


	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}


	public int getCurrent() {
		return current;
	}


	public void setCurrent(int current) {
		this.current = current;
	}


	
	

	
	
}
