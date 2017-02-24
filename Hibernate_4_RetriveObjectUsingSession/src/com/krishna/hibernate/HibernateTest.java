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
		usd.setUserName("Hare Krishna Hare Rama1");
		usd.setAddress("Address11 ");
		usd.setDescription("description11 ");
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
		 
		try {
			session.getTransaction().commit();	
		} catch (Exception e) {
			System.out.println("Exception : "+ e);
		}
		finally {
			session.close();
			buildSessionFactory.close();
			System.out.println("usd name is "+ usd.getUserName());
			usd.setUserName("Test1");
			System.out.println("usd name is "+ usd.getUserName());
		}
	}
}

// Above code show if we close session and before closing session we fetch data from db and FetchType is "EAGER" 
// which is default fetch type ,then object still contain data ,but if we try to change data then it is not in 
// sync with db but object can hold updated data as show in above example for userName 
