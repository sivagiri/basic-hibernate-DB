package com.siva.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.siva.hibernateutil.HibernateUtil;
import com.siva.model.Login;


public class LoginDAOImpl implements LoginDAO {
	
	private SessionFactory sf;
	
	public LoginDAOImpl(SessionFactory sf)
	{
		this.sf = sf;
	}

	@Override
	public Login getUserByCredentials(String username, String password,String role) {
		 sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Login where username=:id and PASSWORD=:pwd and role=:roles");
		query.setString("id", username);
		query.setString("pwd", password);
		query.setString("roles", role);
		Login login = (Login) query.uniqueResult();
		if(login != null){
			System.out.println("User Retrieved from DB::"+login);
		}
		tx.commit();
		session.close();
		return login;
	}

}
