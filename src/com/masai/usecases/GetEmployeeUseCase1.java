package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Employee;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.EmployeeException;

public class GetEmployeeUseCase1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee id:");
		int id = sc.nextInt();
		
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		//Employee employee;
		try {
			Employee employee = dao.getEmployeeById(id);
			System.out.println(employee);
		} catch (EmployeeException ee) {
			// TODO Auto-generated catch block
			System.out.println(ee.getMessage());
		}
		
	
		
	}
	

	
	
	
}
