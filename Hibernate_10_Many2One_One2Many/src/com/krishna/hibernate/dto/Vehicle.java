package com.krishna.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicle_id;
	private String vehicle_name;
	
	//explination already written in UserDetail class
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetails usrObj;
	
	public UserDetails getUsrObj() {
		return usrObj;
	}
	public void setUsrObj(UserDetails usrObj) {
		this.usrObj = usrObj;
	}
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getVehicle_name() {
		return vehicle_name;
	}
	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}
	
	
	
}
