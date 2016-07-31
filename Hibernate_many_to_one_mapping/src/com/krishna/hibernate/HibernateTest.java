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
		

		Vehicle veh1 = new Vehicle();
		veh1.setVehicle_name("i20-CNG");
		
		usd.getVehicle().add(veh);
		usd.getVehicle().add(veh1);
		veh.setUsrObj(usd);
		veh1.setUsrObj(usd);
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();

		session.save(usd);
		session.save(veh);
		session.save(veh1);
		session.getTransaction().commit();
		session.close();
		
	}

}
