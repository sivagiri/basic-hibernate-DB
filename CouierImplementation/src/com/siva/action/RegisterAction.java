package com.siva.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.siva.dao.RegisterDAO;
import com.siva.dao.RegisterDAOImpl;
import com.siva.hibernateutil.HibernateUtil;
import com.siva.model.Register;


public class RegisterAction extends ActionSupport implements ModelDriven<Register> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SessionFactory factory = HibernateUtil.getSessionFactory();

	
	private Register register = new Register();
	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public List<Register> getRegisterList() {
		return registerList;
	}

	public void setRegisterList(List<Register> registerList) {
		this.registerList = registerList;
	}

	private List<Register> registerList = new ArrayList<Register>();
	private RegisterDAO registerDAO = new RegisterDAOImpl(factory);

	@Override
	public Register getModel() {
		// TODO Auto-generated method stub
		return register;
	}
	
	public String add()
	{
		registerDAO.saveUser(register);
		return SUCCESS;
	}
	
	public String list()
	{
		registerList = registerDAO.listRegister();
		return SUCCESS;
	}

}
