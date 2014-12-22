<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register</title>
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
		
</head>
<body>

	<h3>Registration Details</h3>
	<s:form action="addRegister">
		<s:textfield name="username" label="User ID" />
		<s:textfield name="password" label="Password" />
		<s:textfield name="username" label="User ID" />
		<s:textfield name="fname" label="fname" />
		<s:select name="departments" id="departments"  		headerValue="Select Product" listKey="deptid" 		listValue="departmentname" headerKey="-1" label="departmentlist"
		list="departmentlist" />


	<s:select name="designation" id="designation" 	 headerKey="-1" label="designationList"
		list="{}" />
		
        <s:textfield name="email" label="email" />
		<s:textfield name="mobile" label="mobile" />
		<s:submit value="Register" />
		<s:reset value="Cancel"></s:reset>
	
	</s:form>

        <script src="js/getlist.js" type="text/javascript"></script>
 
</body>
 
</html>