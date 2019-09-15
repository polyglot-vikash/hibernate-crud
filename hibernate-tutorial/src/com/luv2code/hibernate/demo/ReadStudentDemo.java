package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
							
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// Start the transaction
			session.beginTransaction();
			
			// Read the students from the database
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='kumar'").list();
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s"
					+ " where s.firstName='vikash'" + " OR " + " s.lastName = 'kumar'").list();
			
			System.out.println("Students whose firstName is Vikash or lastName is Kumar");
			displayStudents(theStudents);
			// commit the transaction
			session.getTransaction().commit();
			
				
		} finally {
			factory.close();
		}
		
		

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents)
			System.out.println(tempStudent);
	}

}
