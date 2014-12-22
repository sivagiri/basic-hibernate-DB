package com.siva.model;

public class Designation {
	
	private int desig_id;
	private int dept_id;
	private String designationname;  
	
	public int getDesig_id() {
		return desig_id;
	}
	public void setDesig_id(int desig_id) {
		this.desig_id = desig_id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDesignationname() {
		return designationname;
	}
	public void setDesignationname(String designationname) {
		this.designationname = designationname;
	}
	@Override
	public String toString() {
		return "Designation [desig_id=" + desig_id + ", dept_id=" + dept_id
				+ ", designationname=" + designationname + "]";
	}
	

}
