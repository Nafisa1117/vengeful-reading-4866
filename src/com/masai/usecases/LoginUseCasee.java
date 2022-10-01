package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Employee;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.EmployeeException;

public class LoginUseCasee {
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String upassword = sc.next();
		
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			Employee employee = dao.loginEmployee(uname, upassword);
			System.out.println("Welcome Employee:"+employee.getName());
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
