<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
    
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%
   	String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+""+request.getServerPort();
   %>
   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	${msg }
	<html:form action="/login">
		<table border="0">
			<tr>
				<td>UserName:</td>
				<td>
				<html:text property="username"></html:text>
				</td>
			</tr>
			<tr>
				<td>Passwprd:</td>
				<td>
				<html:password property="password"></html:password>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Login"></td>
			</tr>
		</table>
	
	
	</html:form>
</body>
</html>