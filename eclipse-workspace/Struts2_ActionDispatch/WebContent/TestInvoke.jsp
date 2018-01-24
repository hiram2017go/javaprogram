<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
µÚÒ»ÖÖµ÷ÓÃ·½Ê½:<br>
<a href="<%=path %>/user!login.action">login</a>|<a href="<%=path %>/user!register.action">Register</a>
<hr>µÚ¶þÖÖµ÷ÓÃ·½Ê½<br>
<a href="<%=path %>/userLogin.action">login</a>|<a href="<%=path %>/userRegister.action">Register</a>
<hr>µÚÈýÖÖµ÷ÓÃ·½Ê½<br>
<a href="<%=path %>/loginAction.action">login</a>|<a href="<%=path %>/registerAction.action">Register</a>

</body>
</html>