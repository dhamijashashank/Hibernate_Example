package com.krishna.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krishna.hibernate.dto.FourWheeler;
import com.krishna.hibernate.dto.TwoWheeler;
import com.krishna.hibernate.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Vehicle veh = new Vehicle();
		veh.setVehicle_name("Swift-CNG1");
		
		TwoWheeler two = new TwoWheeler();
		two.setSteeringType("Activa");
		two.setVehicle_name("Bike");
		
		FourWheeler four = new FourWheeler();
		four.setSteeringWheel("Power ");
		four.setVehicle_name("Porche");

		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		session.save(veh);
		session.save(two);
		session.save(four);
		session.getTransaction().commit();
		session.close();
		
	}

}
