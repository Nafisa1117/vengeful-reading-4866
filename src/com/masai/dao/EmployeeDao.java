package com.masai.dao;

import java.util.List;


import com.masai.bean.Employee;
import com.masai.bean.EmployeeDTO;
import com.masai.exceptions.CourseExceptions;
import com.masai.exceptions.EmployeeException;

public interface EmployeeDao {
	
	//1method:---from this method,all the values of table employee will be inserted in sql table
	public String registerEmployee(int id,String name, String phoneNum,String email, String department, int salary );
	
	
	//2method:---using bean class ,we can do easily
	public String registerEmployee2(Employee employee);
	
	
	//client may throw the employee exception
	public Employee getEmployeeById(int id)throws EmployeeException;

	//taking return type Employee obj , for better
	public Employee loginEmployee(String username, String password)throws EmployeeException;

	//we are taking list, q ki list ko hum sort kr skte h etc
	public List<Employee> getAllEmployeeDetails()throws EmployeeException;

	
	//we are passing here 2 exceptions,suppose if Employee is not threr then EmployeeException and if course is not there then CourseException
	public String registerEmployeeInsideACourse(int cid, int id)throws EmployeeException,CourseExceptions;
	
	//
	//public List<EmployeeDTO> getAllEmployeesByCname(String cname)throws CourseExceptions;


	public List<EmployeeDTO> getAllEmployeesByCname(String cname)throws CourseExceptions;
	


}
