package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Employee;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class RegisterEmployeeUseCase2 {

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
			
			Employee employee = new Employee();
			
			employee.setName(sname);
			employee.setPhoneNum(snum);
			employee.setEmail(semail);
			employee.setDepartment(sdept);
			employee.setSalary(ssal);
			
			String result = dao.registerEmployee(ssal, sname, snum, semail, sdept, ssal);
			
			System.out.println(result);
		}
}
