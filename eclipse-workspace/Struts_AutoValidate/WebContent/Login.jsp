<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
  <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
  <%
  	String path = request.getContextPath();
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试手动验证</title>
</head>
<body>
${requestScope.error }


<html:form action="/login.do">
<table>
	<tr>
		<td>Username</td>
		<td><html:text property="username"></html:text><html:errors property="username" /> </td>
	</tr>
	<tr>
		<td>Password</td>
		<td><html:password property="password"></html:password><html:errors property="password" /></td>
	</tr>
	<tr>
		<td>Position:</td>
		<td>
			<html:select property="username">
				<html:options collection="LIST" property="id" labelProperty="name"/> 
			</html:select>
		</td>
	</tr>
	<tr>
		<td colspan="2"><html:submit></html:submit></td>
	</tr>
</table>

</html:form>

</body>
</html>