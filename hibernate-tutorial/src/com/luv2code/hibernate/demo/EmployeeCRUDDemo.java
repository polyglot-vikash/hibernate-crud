package com.luv2code.hibernate.demo;



public class EmployeeCRUDDemo {

	public static void main(String[] args) {
		
		EmployeeCRUD e = new EmployeeCRUD();
		
		System.out.println("Starting the operations ....");
		e.createEmployee();
		e.readEmployee(1);
		e.deleteEmployee(2);
		
		System.out.println("Done!");
	
	}

}
