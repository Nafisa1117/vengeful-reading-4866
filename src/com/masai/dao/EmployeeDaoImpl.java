package com.masai.dao;

import java.sql.Connection;

import com.masai.bean.Employee;
import com.masai.utility.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.utility.DBconnUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String registerEmployee(int id, String name, String phoneNum, String email, String department, int salary) {
		
		String message = "Not Inserted..";
		
		//providing connection using try resource here
		try(Connection conn =DBconnUtil.provideConnection()){
			//here we are inserting vales in employee table
			PreparedStatement ps =  conn.prepareStatement("insert into employee(name,phoneNUm,email,department,salary)values(?,?,?,?,?)");
			
			ps.setString(1,name);
			ps.setString(2,phoneNum);
			ps.setString(3, email);
			ps.setString(4,department);
			ps.setInt(5,salary);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Employee Registered successfully!";
				
			}
		}catch(SQLException e) {
			message = e.getMessage();
		
			
		}
		
		
		
		
		
		
		
		
		
		
		return message;
	}

	@Override
	public String registerEmployee2(Employee employee) {
		
			String message = "Not Inserted..";
			
			//providing connection using try resource here
			try(Connection conn =DBconnUtil.provideConnection()){
				//here we are inserting vales in employee table
				PreparedStatement ps =  conn.prepareStatement("insert into employee(name,phoneNUm,email,department,salary)values(?,?,?,?,?)");
				
				ps.setString(1,employee.getName());
				ps.setString(2,employee.getPhoneNum());
				ps.setString(3, employee.getEmail());
				ps.setString(4,employee.getDepartment());
				ps.setInt(5,employee.getSalary());
				
				int x = ps.executeUpdate();
				
				if(x>0) {
					message = "Employee Registered successfully!";
					
				}
			}catch(SQLException e) {
				message = e.getMessage();
			
				
			}
			
			
			
			
			
			
			
			
			
			
			return message;
	}

}
