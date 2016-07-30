package com.krishna.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity (name="USER_DETAIL")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	//@ElementCollection (fetch=FetchType.LAZY)// this will throw exception org.hibernate.LazyInitializationException: as explained in HiberateTestFile
	@ElementCollection (fetch=FetchType.EAGER)// this will run successfully
	@JoinTable(name="USER_ADDRESS" , 
		joinColumns=@JoinColumn(name="USER_ID")
	)
	Collection<Address> addressColl = new ArrayList<>(); 
	
	public Collection<Address> getAddressColl() {
		return addressColl;
	}
	public void setAddressColl(Collection<Address> addressColl) {
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
