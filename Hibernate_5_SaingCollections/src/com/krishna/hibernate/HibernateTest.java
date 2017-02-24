package com.krishna.hibernate;

import javax.persistence.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krishna.hibernate.dto.Address;
import com.krishna.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails usd = new UserDetails();
		usd.setUserId(1);
		usd.setUserName("Hare Krishna Hare Rama");

		Address adr1 = new Address();
		adr1.setCity("Mathura");
		adr1.setPincode("123455");
		adr1.setState("U.P");
		adr1.setStreet("KRISHNA NAGAR");
		
		
		Address adr2 = new Address();
		adr2.setCity("Mathura1");
		adr2.setPincode("1234551");
		adr2.setState("U.P1");
		adr2.setStreet("KRISHNA NAGAR1");
		
		usd.getAddressColl().add(adr1);
		usd.getAddressColl().add(adr2);
		
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		session.save(usd);
		try {
			session.getTransaction().commit();	
		} catch (Exception e) {
			System.out.println("Exception : "+ e);
		}
		finally {
			session.close();
			buildSessionFactory.close();
	
		}		
	}
}

// Use of ElementCollection and @JoinTable(name="XYZ")
// use of @Embeddable also we use it on top of address class as we didn't want to create seprate table for this 
