package com.masai.usecases;

import java.util.List;

import com.masai.bean.Employee;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.EmployeeException;

public class GetAllEmployeeUseCase {
	
	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			List<Employee> employee = dao.getAllEmployeeDetails();
			
			employee.forEach(s -> {
				System.out.println("employee Name"+s.getName());
				System.out.println("Employee email"+s.getEmail());
				System.out.println("=====================");
				});
			
			
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
