package com.krishna.hibernate.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;


@Entity (name="USER_DETAIL")
public class UserDetails {
	
	@Id
	private int userId;
	private String userName;
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS")
	Set<Address> addressColl = new HashSet<>(); 
	
	public Set<Address> getAddressColl() {
		return addressColl;
	}
	public void setAddressColl(Set<Address> addressColl) {
		this.addressColl = addressColl;
	}
	public int getUserId() {
		return userId;
	}	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
