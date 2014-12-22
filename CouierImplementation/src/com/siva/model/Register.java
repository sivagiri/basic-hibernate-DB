package com.siva.model;

public class Register {
	
	private String id;
	private String username;
	private String password;
	private String fname;
	private int departmentid;
	private int designationid;
	private String role;
	private String email;
	private String mobileno;
	
	
	public int getDesignationid() {
		return designationid;
	}
	public void setDesignationid(int designationid) {
		this.designationid = designationid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		return "Register [username=" + username + ", password=" + password
				+ ", fname=" + fname + ", departmentid=" + departmentid
				+ ", desgnationid=" + designationid + ", role=" + role
				+ ", email=" + email + ", mobileno=" + mobileno + "]";
	}
	
	

}
