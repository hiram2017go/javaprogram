<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
    
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
	
	WelCome :${LoginForm.username }
</body>
</html>