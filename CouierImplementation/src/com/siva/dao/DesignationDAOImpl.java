package com.siva.dao;
import java.util.List;
import org.hibernate.Session;
import com.siva.hibernateutil.*;
import com.siva.model.Designation;
public class DesignationDAOImpl implements DesignationDAO {
	@SuppressWarnings("unchecked")
	public List<Designation> listdesignationfordept(int dno) {
		List<Designation> designationlist = null;
		try {
			Session session=	HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query=session.createQuery(" FROM Designation  WHERE dept_id=:did");
			query.setInteger("did", dno);
			designationlist=query.list();
			
			System.out.println(designationlist.get(0).getDesignationname());
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return designationlist;
	}
}