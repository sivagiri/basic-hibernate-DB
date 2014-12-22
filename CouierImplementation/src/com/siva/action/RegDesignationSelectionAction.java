package com.siva.action;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;
import com.siva.dao.DepartmentDAO;
import com.siva.dao.DepartmentDAOImpl;
import com.siva.dao.DesignationDAO;
import com.siva.dao.DesignationDAOImpl;
import com.siva.model.Department;
import com.siva.model.Designation;
public class RegDesignationSelectionAction implements Action,ApplicationAware{
	private String dummyMsg;
	private List<Department> departmentlist;
	private List<Designation> designationlist;
	String selecteddepartment;


	private Map<String, Object> contextAttributes = null;

	public String populate()
	{
		System.out.println("in populate methods");
		DepartmentDAO deptdaoimp=new DepartmentDAOImpl();
		departmentlist=deptdaoimp.listdept(); 
		
		contextAttributes.put("deptlist", departmentlist);
		System.out.println(departmentlist.get(0));

			
		dummyMsg="Call by JQUERY done";
		return "populate";
	}


	@SuppressWarnings("unchecked")
	public String execute() {
		System.out.println("in execute methods");
		System.out.println(selecteddepartment);
		//if(contextAttributes!=null)
			departmentlist=	((List<Department>) contextAttributes.get("deptlist"));
    
			

		DesignationDAO designationdaoimpl=new DesignationDAOImpl();
		designationlist=designationdaoimpl.listdesignationfordept(Integer.parseInt(selecteddepartment));
		System.out.println(designationlist.get(0).getDept_id());
		System.out.println(designationlist.get(0).getDesignationname());
		dummyMsg="Call by JQUERY done in execute";
		
		convertToJSON();
		return "success";
	}

	
	
	public void convertToJSON()
	{
		Gson gson = new Gson();
		
		String jsonString = gson.toJson(designationlist);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		try {
			System.out.println("checking..."+jsonString);
			response.getWriter().print(new Gson().toJson(designationlist));
			response.getWriter().close();
           // response.getWriter().print(new Gson().toJson(mlist));

			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

	public String getDummyMsg() {
		return dummyMsg;
	}


	public void setDummyMsg(String dummyMsg) {
		this.dummyMsg = dummyMsg;
	}


	@Override
	public void setApplication(Map<String, Object> contextAttributes) {
		this.contextAttributes=contextAttributes;
	}


	public List<Department> getDepartmentlist() {
		return departmentlist;
	}


	public void setDepartmentlist(List<Department> departmentlist) {
		this.departmentlist = departmentlist;
	}


	public List<Designation> getDesignationlist() {
		return designationlist;
	}


	public void setDesignationlist(List<Designation> designationlist) {
		this.designationlist = designationlist;
	}


	public String getSelecteddepartment() {
		return selecteddepartment;
	}


	public void setSelecteddepartment(String selecteddepartment) {
		this.selecteddepartment = selecteddepartment;
	}


	public Map<String, Object> getContextAttributes() {
		return contextAttributes;
	}


	public void setContextAttributes(Map<String, Object> contextAttributes) {
		this.contextAttributes = contextAttributes;
	}




}