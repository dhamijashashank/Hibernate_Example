package com.krishna.hibernate.dto;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{

	private String steeringType ;

	public String getSteeringType() {
		return steeringType;
	}

	public void setSteeringType(String steeringType) {
		this.steeringType = steeringType;
	}
	
}
