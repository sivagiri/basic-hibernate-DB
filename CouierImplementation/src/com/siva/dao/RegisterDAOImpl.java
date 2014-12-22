package com.siva.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.siva.hibernateutil.HibernateUtil;
import com.siva.model.Register;

public class RegisterDAOImpl  implements RegisterDAO{

private SessionFactory sf;
Session session;
Transaction tx;
	public RegisterDAOImpl(SessionFactory sf)
	{
		this.sf = sf;
	}

	@Override
	public void saveUser(Register register) {
		try {
			 sf = HibernateUtil.getSessionFactory();
		         session = sf.openSession();

				 tx= session.beginTransaction();
			session.save(register);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Register> listRegister() {
		List<Register> registerlist = null;
		try {
			registerlist = session.createQuery("from Register").list();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return registerlist;
	}
	
	











}
