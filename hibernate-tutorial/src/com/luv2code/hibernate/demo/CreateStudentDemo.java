package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
							
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			// Create a student Object
			System.out.println("Creating a new student object");
			
			Student s = new Student("VIkash", "kumar", "vikash@gmail.com");
			
			// Start the transaction
			session.beginTransaction();
			
			// Save the object
			System.out.println("Savoing the student");
			session.save(s);

			// commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
		

	}

}
