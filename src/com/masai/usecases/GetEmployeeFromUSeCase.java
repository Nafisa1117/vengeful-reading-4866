package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.EmployeeDTO;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class GetEmployeeFromUSeCase {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Name");
		String cname = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			List<EmployeeDTO> dtos = dao.getAllEmployeesByCname(cname);
			
			dtos.forEach(dto -> System.out.println(dto));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}
