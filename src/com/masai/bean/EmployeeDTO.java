package com.masai.bean;

public class EmployeeDTO {
	
	//some feilds from Employee table
	private int id;
	private String name;
	private String email;
	
	//some feilds from Cousre
	private String cname;
	private int fee;
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(int id, String name, String email, String cname, int fee) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cname = cname;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", email=" + email + ", cname=" + cname + ", fee=" + fee
				+ "]";
	}
	

}
