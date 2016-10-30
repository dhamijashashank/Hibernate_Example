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
		usd.setUserName("Hare Krishna Hare Rama");
		usd.setAddress("Address6 ");
		usd.setDescription("description6 ");
		usd.setJoiningDate(new Date());
		
		UserDetails usd1 = new UserDetails();
		usd1.setUserName("Hare Krishna Hare Rama");
		usd1.setAddress("Address ");
		usd1.setDescription("description ");
		usd1.setJoiningDate(new Date());
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		session.save(usd);
		session.save(usd1);
		session.getTransaction().commit();
		session.close();
		buildSessionFactory.close();
	}

}
