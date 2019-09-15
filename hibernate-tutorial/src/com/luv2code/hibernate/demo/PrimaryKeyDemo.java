package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {
			// Create a student Object
			System.out.println("Creating 3 students object");

			Student s1 = new Student("VIkash", "kumar", "vikash@gmail.com");
			Student s2 = new Student("Suraj", "Kumar", "suraj@gmail.com");
			Student s3 = new Student("Amit", "Singh", "amit@abc.com");
			
			// Start the transaction
			session.beginTransaction();

			// Save the object
			System.out.println("Savoing the student");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			// commit the transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}
}
