package com.example.dsm;

import java.util.List;
import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===============MENU=============");
		System.out.println("1.Add distributor");
		System.out.println("2.display all distributors");
		System.out.println("3.Exit");
		System.out.println("===============MENU=============");
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("please enter your choice...!");
		int option=sc.nextInt();
		if(option==1) {
			System.out.println("please enter city");
			String city=sc.next();
			System.out.println("please enter state");
			String state=sc.next();
			System.out.println("please enter pincode");
			String pin=sc.next();
			System.out.println("please enter country");
			String country=sc.next();
			Contact contact= new Contact();
			contact.setCity(city);
			contact.setCountry(country);
			contact.setPinCode(pin);
			contact.setState(state);
			System.out.println("please enter distributer name ");
			String distributor=sc.next();
			System.out.println("please enter distributer service ");
			String service=sc.next();
			Distributor d= new Distributor();
			d.setDistributorContact(contact);
			d.setDistributorName(distributor);
			d.setDistributorService(service);
			addDistributor(d); 
			
		}else if(option==2) {
			displayAllDistribuors();
		}else if(option ==3) {
			System.exit(0);
		}
		
	    
	}

	private static void displayAllDistribuors() {
		Session session=getHibernateSession();
		Query query=session.createQuery("from Distributor");//here persistent class name is Emp  
		List<Distributor> list=query.list();  
		for(Distributor d:list) {
			System.out.println(d);
		}
		
	}

	private static Session getHibernateSession() {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		return session;
	}
	
	private static void addDistributor(Distributor d) {
		Session session=getHibernateSession();
		Transaction t=session.beginTransaction(); 
		session.save(d);
		System.out.println("added successfully");
		t.commit();
		session.close();
	}

}
