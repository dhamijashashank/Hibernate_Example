package com.krishna.hibernate.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicle_id;
	private String vehicle_name;
	
	@ManyToMany(mappedBy="vehicle")
	private Set<UserDetails> usrObj = new HashSet<>();
	
	public Set<UserDetails> getUsrObj() {
		return usrObj;
	}
	public void setUsrObj(Set<UserDetails> usrObj) {
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
