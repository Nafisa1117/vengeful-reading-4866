package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class AllocateEmployeeToCourse {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the cid");
		int cid = sc.nextInt();
		
		System.out.println("Enter the id");
		int id = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String result = dao.registerEmployeeInsideACourse(cid, id);
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
}
