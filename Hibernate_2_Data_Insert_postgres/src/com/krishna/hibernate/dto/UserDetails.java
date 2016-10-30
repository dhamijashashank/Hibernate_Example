package com.krishna.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="USER_DETAIL")
public class UserDetails {
	
	@Id
	private int userId;
	private String userName;
	
	@Id
	@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column (name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
