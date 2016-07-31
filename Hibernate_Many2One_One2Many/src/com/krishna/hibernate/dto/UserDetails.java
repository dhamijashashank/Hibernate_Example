package com.krishna.hibernate.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity (name="USER_DETAIL")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	// if we simple use @OneToMany mapping only and @ManyToOne in another class then it will create one relational table having  
	// table1 name = Table1_Table2 and to stop them we use mappedBy i.e no extra table is created for mapping between both tables  
	// one more thing if we use this then in table userdetails only two coloum are created i.e userid and username no coloum is there for vehicle object
	// as its mapped by userObj so its very useful
	@OneToMany(mappedBy="usrObj")
	private Set<Vehicle> vehicle = new HashSet<>(); 

	public Set<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Set<Vehicle> vehicle) {
		this.vehicle = vehicle;
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
