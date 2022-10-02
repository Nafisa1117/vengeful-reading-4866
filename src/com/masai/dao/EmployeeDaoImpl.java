package com.masai.dao;

import java.sql.Connection;

import com.masai.bean.Employee;
import com.masai.bean.EmployeeDTO;
import com.masai.exceptions.CourseExceptions;
import com.masai.exceptions.EmployeeException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


	@Override
	public Employee getEmployeeById(int id)throws EmployeeException {
		
		Employee employee = null;
		
		try(Connection conn = DBconnUtil.provideConnection()){
			
		PreparedStatement ps = 	conn.prepareStatement("select * from employee where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int r = rs.getInt("id");
			String n =rs.getString("name");
			String p = rs.getString("phoneNum");
			String e = rs.getString("email");
			String d = rs.getString("department");
			int s = rs.getInt("salary");
			
			//i just mapped my resulset data into employee object
			employee = new Employee(r, n, p, e, d, s);
		}else {
			//if employee is not there then, exception throw
			throw new EmployeeException("Employee does not exist with id "+id);
		}
		
		}catch(SQLException e) {
			//e.printStackTrace();
			//if logical erroe happen then, this exception will throw
			throw new EmployeeException(e.getMessage());
		}
		

		return employee;
	}
	
	@Override
	public Employee loginEmployee(String username, String password)throws EmployeeException{
		
		Employee employee = null;
		
		try(Connection conn = DBconnUtil.provideConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("select * from employee where email = ? AND password = ?");
			
			//binding the username and password
			ps.setString(1, password);
			ps.setString(2, password);
			
			//it will gonna return reslutset here
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				int r = rs.getInt("id");
				String n =rs.getString("name");
				String p = rs.getString("phoneNum");
				String e = rs.getString("email");
				String d = rs.getString("department");
				int s = rs.getInt("salary");
				
				//i just mapped my resulset data into employee object
				employee = new Employee(r, n, p, e, d, s);
			}else {
				//if employee is not there then, exception throw
				throw new EmployeeException("Invalid Username or Password");
			}
			
		
		}catch(SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return employee;
	}


	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> employee = new ArrayList<>();
		
		try(Connection conn = DBconnUtil.provideConnection()) {
			
		PreparedStatement ps = conn.prepareStatement("select *  from employee");
		
		ResultSet rs =  ps.executeQuery();
		
		while(rs.next()) {
			int r = rs.getInt("id");
			String n =rs.getString("name");
			String p = rs.getString("phoneNum");
			String e = rs.getString("email");
			String d = rs.getString("department");
			int s = rs.getInt("salary");
			
			//i just mapped my resulset data into employee object
			Employee employees = new Employee(r, n, p, e, d, s);
		
			employee.add(employees);
		}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		if(employee.size() == 0) {
			throw new EmployeeException("No EMployee Found");
		}

		return employee;
	}


	@Override
	public String registerEmployeeInsideACourse(int cid, int id) throws EmployeeException, CourseExceptions {
		// TODO Auto-generated method stub
		String message = "Npt Registered";
		
		//3 times we need to create preoared stattemnet, first to check the Employee, second to check the corse, third  insert the table in  the linkung statement
		try(Connection conn = DBconnUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select *  from employee where id =?");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select *  from course where cid=?");
				ps2.setInt(1, id);
				ResultSet rs2 = ps2.executeQuery();
				
			if(rs2.next()) {
				PreparedStatement ps3 = conn.prepareStatement("insert into course_employee values(?,?)");
				ps3.setInt(1, cid);
				ps3.setInt(1, id);
				
				//update
				int x =ps3.executeUpdate();
				
				if(x > 0) 
					message = "Employee Registered inside the cousre successfully...";
				else
					throw new EmployeeException("Technical Error...");
				
			}else {
				throw new CourseExceptions("Invalid Course...");
			}
				
				
				
			}else {
				throw new EmployeeException("Invalid Employee...");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		
		
		return message;
		
		
		
		
		
	}
	@Override
	public List<EmployeeDTO> getAllEmployeesByCname(String cname) throws CourseExceptions {
		// TODO Auto-generated method stub
		List<EmployeeDTO> dtos = new ArrayList<>();
		
		
		try(Connection conn = DBconnUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select \r\n"
					+ "s.id,s.name,s.email,c.cname,c.fee \r\n"
					+ "from employee s INNER JOIN course c INNER JOIN course_employee cs\r\n"
					+ "ON\r\n"
					+ "s.id = sc.id AND c.cid = sc.cid AND c.cname = ?;");
			
			ps.setString(1, cname);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int r = rs.getInt("id");
				String n = rs.getString("name");
				String em = rs.getString("email");
				
				String cn = rs.getString("cname");
				int f = rs.getInt("fee");
			
				EmployeeDTO dto = new EmployeeDTO(r, n, em, cn, f);
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new CourseExceptions(e.getMessage());
		}
		
		
		if(dtos.isEmpty())
			throw new CourseExceptions("NO EMployee Found ...");
		
		
		return dtos;
	}
	
	
	

}
