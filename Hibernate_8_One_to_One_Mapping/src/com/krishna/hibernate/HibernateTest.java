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
		// without mapping if we want to store both object in db then we have to explicitly save both of it. even though you will get following error
		//		Exception in thread "main" org.hibernate.MappingException: Could not determine type for: com.krishna.hibernate.dto.Vehicle, at table: USER_DETAIL, for columns: [org.hibernate.mapping.Column(vehicle)]
		//				at org.hibernate.mapping.SimpleValue.getType(SimpleValue.java:435)
		//				at org.hibernate.mapping.SimpleValue.isValid(SimpleValue.java:402)
		//				at org.hibernate.mapping.Property.isValid(Property.java:226)
		//				at org.hibernate.mapping.PersistentClass.validate(PersistentClass.java:595)
		//				at org.hibernate.mapping.RootClass.validate(RootClass.java:265)
		//				at org.hibernate.boot.internal.MetadataImpl.validate(MetadataImpl.java:329)
		//				at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:482)
		//				at org.hibernate.cfg.Configuration.buildSessionFactory(Configuration.java:707)
		//				at org.hibernate.cfg.Configuration.buildSessionFactory(Configuration.java:723)
		//				at com.krishna.hibernate.HibernateTest.main(HibernateTest.java:21)

		
		//but it is not mandatory to save both object means if we save any one then code runs fine successfully 
		// if we are using mapping then it is mandatory to save both object in db otherwise it will throw exception.
		
		//session.save(usd);
		//session.save(veh);
		
		
		session.save(usd);
		session.save(veh);
		session.getTransaction().commit();
		session.close();
		buildSessionFactory.close();
		
	}

}
