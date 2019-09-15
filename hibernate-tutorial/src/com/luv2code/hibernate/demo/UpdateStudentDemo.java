package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
							
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			// Start the transaction
			session.beginTransaction();
			System.out.println("Reading student with id " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student");
			myStudent.setFirstName("Ramesh");
		
			session.getTransaction().commit(); // commiting the transaction will auto update the object in the DB
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email = 'foo@gmail.com' where id = " + studentId)
					.executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
		
		

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents)
			System.out.println(tempStudent);
	}

}
