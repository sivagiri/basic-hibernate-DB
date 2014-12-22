package com.siva.action;

import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.siva.dao.LoginDAO;
import com.siva.dao.LoginDAOImpl;
import com.siva.hibernateutil.HibernateUtil;
import com.siva.model.Login;

public class LoginAction implements Action, ModelDriven<Login> {
	
	@Override
	public String execute() throws Exception {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		LoginDAO userDAO = new LoginDAOImpl(factory);
		Login userDB = userDAO.getUserByCredentials(user.getUsername(), user.getPassword(),user.getRole());
		if(userDB == null) return ERROR;
		else {
			user.setUsername(userDB.getUsername());
			user.setPassword(userDB.getPassword());
			user.setRole(userDB.getRole());

			return SUCCESS;
		}
	}

	@Override
	public Login getModel() {
		return user;
	}
	
	private Login user = new Login();
	

	
}
