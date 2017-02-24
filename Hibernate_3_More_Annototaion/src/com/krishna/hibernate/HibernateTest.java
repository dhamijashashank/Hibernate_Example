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
	
	
//	Explination for fetchType
	
	
//	Difference Between EAGER and LAZY
//
//	Okay, so we talked about the fact that FetchType.LAZY is the default fetch type for all Hibernate annotation relationships. We also talked about the fact that when you use the Lazy fetch type, Hibernate won’t load the relationships for that particular object instance. So then, what’s the difference between Eager and Lazy?
//
//	Fetch type Eager is essentially the opposite of Lazy, Eager will by default load ALL of the relationships related to a particular object loaded by Hibernate. This means that if you change the relationship to be this:
//
//	view plaincopy to clipboardprint?
//	import javax.persistence.FetchType;
	
//	@OneToOne(fetch=FetchType.EAGER)  
//	@JoinColumn(name="user_profile_id")  
//	private Profile getUserProfile()  
//	{  
//	  return userProfile;  
//	}  
//	Hibernate will now load the user profile into the user object by default. This means that if you access user.getUserProfile() it won’t be NULL (unless the joining table actually doesn’t contain a matching row by the “user_profile_id” join column).
//
//	So, the long story short here is:
//
//	FetchType.LAZY = Doesn’t load the relationships unless explicitly “asked for” via getter
//	FetchType.EAGER = Loads ALL relationships
//
//	Pros and Cons
//
//	If using the lazy loading approach can cause NullPointerExceptions, then why the heck would you want to use it? Well, let’s just take a minute to think about this.
//
//	Let’s assume we had a User object that has 10 different relationships to other objects. Let’s also say that you have a user that’s trying to login and you just want to check to see if their username and password is correct and matches what’s stored in the database. Would you really want to load ALL 10 relationships and NOT make use of ANY of those loaded relationships? Remember, loading things from a database is fairly “expensive” in terms of the time it takes to load all that information into a Java objects AND keep them in memory. And what happens if one of the relationships points to an object that ALSO has 10 relationships (and all of those are set up as fetch type EAGER). Think of the cascading massacre of objects loaded from the database into memory!
//
//	The way I like to put it is like this:
//
//	EAGER: Convenient, but slow
//	LAZY: More coding, but much more efficient

}
