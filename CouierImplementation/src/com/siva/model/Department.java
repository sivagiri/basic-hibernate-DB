package com.siva.model;

public class Department {
	
	private int deptid;
	private String departmentname;
	
	
	
	

	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", departmentname="
				+ departmentname + "]";
	}
	


	
}
