package com.masai.dao;

public interface EmployeeDao {
	
	//from this method,all the values of table employee will be inserted in sql table
	public String registerEmployee(int id,String name, String phoneNum,String email, String department, int salary );
	
	
}
