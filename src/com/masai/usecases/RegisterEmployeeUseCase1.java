package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class RegisterEmployeeUseCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Name: ");
		String sname = sc.next();
		
		System.out.println("Enter Employee Number: ");
		String snum = sc.next();
		
		System.out.println("Enter Employee Email:");
		String semail = sc.next();
		
		System.out.println("Enter Employee Department:");
		String sdept = sc.next();
		
		System.out.println("Enter Employee Salary:");
		int ssal = sc.nextInt();
		
		
		//interface variable and implementation class object
		EmployeeDao dao = new EmployeeDaoImpl();
		
		//create object of implement class and this object having a responsibility to return all this below vakles
		//EmployeeDaoImpl dao = new EmployeeDaoImpl();
		
		String result = dao.registerEmployee(ssal, sname, snum, semail, sdept, ssal);
		
		System.out.println(result);
	}

}
