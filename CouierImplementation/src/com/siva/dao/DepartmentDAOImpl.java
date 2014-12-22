package com.siva.dao;

import java.util.List;

import com.siva.hibernateutil.*;
import com.siva.model.Department;

public class DepartmentDAOImpl implements DepartmentDAO {
 
	@SuppressWarnings("unchecked")
	public List<Department> listdept() {
		List<Department> departmentlist = null;
		try {
			departmentlist= HibernateUtil.getSessionFactory().openSession().createQuery("FROM Department").list();
		//	System.out.println(departmentlist);
			//department = session.createQuery("from Department").list();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return departmentlist;
		
	}
 

}
