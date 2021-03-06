package com.krishna.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity (name="USER_DETAIL_6")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS_6" , 
		joinColumns=@JoinColumn(name="USER_ID")
	)
//	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@GenericGenerator(name="sequence-gen",strategy="sequence")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") },generator = "sequence-gen", type = @Type(type="long") )
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
