package com.krishna.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krishna.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails usd = new UserDetails();
		usd.setUserId(1);
		usd.setUserName("Hare Krishna Hare Rama");
		usd.setAddress("Address1 ");
		usd.setDescription("description1 ");
		usd.setJoiningDate(new Date());
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		session.save(usd);
		session.getTransaction().commit();
		session.close();
		
		
		usd = null;
		session = buildSessionFactory.openSession();
		session.beginTransaction();
		usd = session.get(UserDetails.class, 1);
		System.out.println("usd name is "+ usd.getUserName()); 
		session.close();
		buildSessionFactory.close();
		
		

	}

}
