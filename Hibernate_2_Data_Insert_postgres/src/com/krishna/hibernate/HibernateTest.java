package com.krishna.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krishna.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails usd = new UserDetails();
		usd.setUserId(3);
		usd.setUserName("Hare Krishna Hare Rama");
		
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
