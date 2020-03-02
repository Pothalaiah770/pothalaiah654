package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Stockmanager {

	public static void main(String[] args) {
		Transaction tx=null;
		Session ses=null;
		try{
		
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		 ses=sf.openSession();
		
		tx=ses.beginTransaction();
		
		
		Category category=new Category("Computer");
		
		
		Product pc=new Product("Dell-Pc", "Quad Core Pc", 1200, category);
		
		
		Product laptop=new Product("MacBook", "Apple high end laptop", 2100, category);
		
		
		Product phone=new Product("iphoe5", "Apple best selling smart phone", 499, category);
		
		
		Product tablet=new Product("iPad3", "Apple best selling tablet", 1099, category);
		
		
		Set<Product> products=new HashSet<Product>();
		
		products.add(pc);
		products.add(laptop);
		products.add(phone);
		products.add(tablet);
		
		category.setProducts(products);
		
		ses.save(category);
		System.out.println(ses);
		
		
		ses.getTransaction().commit();
		
		
		ses.close();
		
		
		}catch (Exception e) {
			
			e.printStackTrace();

			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
