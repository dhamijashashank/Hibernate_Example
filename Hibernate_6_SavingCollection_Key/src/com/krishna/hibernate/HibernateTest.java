package com.krishna.hibernate;

import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
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

//@GenericGenerator(name = "hilo-gen", strategy = "hilo")
//@GenericGenerator(name="sequence-gen",strategy="sequence")
//@CollectionId(columns = { @Column(name="ADDRESS_ID") },generator = "sequence-gen", type = @Type(type="long") )
// Purpose of above defined association is following URL : http://www.skill-guru.com/blog/2009/10/10/80priamary-key-generation-strategies-in-hibernate/

// Example of GenericGennerator and GenericValue are as follow
//
//Define the generic generator name at top of the class:
//
//@org.hibernate.annotations.GenericGenerator(
//name = “test-native-strategy”,
//strategy = “native”)
//
//Where strategy is one among the strategies explained below and name is the strategy name. (Which we use when defining id)
//On either getter method or the field declaration we must have:
//@Id
//@GeneratedValue(generator = “test-native-strategy”)
//@Column(name=”user_task_id “)

// In Address Table 6 entry is there which are as follow 
//USER_ADDRESS_6 (USER_ID, ADDRESS_ID, city, pincode, state, street)  , 2 new field is added first is USER_ID and second is ADDRESS_ID 

