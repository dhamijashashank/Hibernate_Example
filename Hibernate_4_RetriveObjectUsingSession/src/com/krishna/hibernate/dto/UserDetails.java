package com.krishna.hibernate.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity (name="USER_DETAIL_Example_4")
public class UserDetails {
	
	@Id
	private int userId;
//	@Basic(fetch=FetchType.LAZY)//@Basic(fetch=FetchType.EAGER)//
	private String userName;
	//If user want that feild is not store in DB make it static or Transiant or use below annotation
//	@Transient
	private String address;
	 
//	@Temporal(TemporalType.TIMESTAMP)// by Default
//	@Temporal(TemporalType.TIME)//if user want to store Time On
//	@Temporal(TemporalType.TIME)// if user want to store Date only
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningDate;
	
	private String description;
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
