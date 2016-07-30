package com.krishna.hibernate;

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
		session.getTransaction().commit();
		session.close();
		
		Session session1 = buildSessionFactory.openSession();
		session1.beginTransaction();
		UserDetails user =(UserDetails)session1.get(UserDetails.class, 1);
		session1.close();
		//throw exception as by default loading stategy is lazy loading and it will
		//load simple attribute by default and load object like address once we call it 
		// and in below case address is not loaded and we try to call after closing session so it throw exception
		
		System.out.println(user.getAddressColl().size());
		
	}

}
