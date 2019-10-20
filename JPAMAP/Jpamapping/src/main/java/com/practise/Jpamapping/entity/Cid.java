package com.practise.Jpamapping.entity;

import java.io.Serializable;

public class Cid implements Serializable {

	private int timestamp;
	
	private int inverterId;

	
	
	public Cid() {
	
	}

	public Cid(int timestamp, int inverterId) {
		super();
		this.timestamp = timestamp;
		this.inverterId = inverterId;
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
	
}
