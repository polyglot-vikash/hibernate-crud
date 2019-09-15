package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class EmployeeCRUD {
	// create a session factory
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			 .addAnnotatedClass(Employee.class)
			 .buildSessionFactory();


	public void createEmployee() {
		Employee e = new Employee("Akash","Kumar", "Amz");
		
		Session session = factory.getCurrentSession();
		try{
			session.beginTransaction();
			session.save(e);
			session.getTransaction().commit();
			System.out.println("created the object");
		} catch(Exception err) {
			System.out.println(err);
		}
		finally {
			session.close();
		}
		
	}
	
	public void readEmployee(int id) {
		Session session = factory.getCurrentSession();
		try{
			session.beginTransaction();
			System.out.println("reading the object with id " + id);
			Employee e = session.get(Employee.class, id);
			System.out.println("Fetched employee object is " +e);
			session.getTransaction().commit();
			System.out.println("Read the object");
		}finally {
			session.close();
		}
		
	}
	
	public void deleteEmployee(int id) {
		Session session = factory.getCurrentSession();
		try{
			session.beginTransaction();
			System.out.println("deleting the object with id " + id);
			session.createQuery("delete from Employee where id = " + id).executeUpdate();
			session.getTransaction().commit();
			System.out.println("Deleted the object");
		}finally {
			session.close();
		}
	}
}

