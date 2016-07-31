package com.krishna.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krishna.hibernate.dto.UserDetails;
import com.krishna.hibernate.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails usd = new UserDetails();
		usd.setUserName("Hare Krishna Hare krishna Krishna Krishna Hare Hare ");
		
		Vehicle veh = new Vehicle();
		veh.setVehicle_name("Swift-CNG");
		usd.setVehicle(veh);
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		// without mapping if we want to store both object in db then we have to explicitly save both of it.
		//but it is not mandatory to save both object means if we save any one then code runs fine successfully 
		// if we are using mapping then it is mandatory to save both object in db otherwise it will throw exception.
		
		//session.save(usd);
		//session.save(veh);
		
		
		session.save(usd);
		session.save(veh);
		session.getTransaction().commit();
		session.close();
		
	}

}
