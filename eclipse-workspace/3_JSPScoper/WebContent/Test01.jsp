<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

 		session.setAttribute("session_name", "session_value2");

		request.setAttribute("request_name", "request_value2");
		
		application.setAttribute("application_name", "application_value2");
		
		response.sendRedirect("Test02.jsp");
%>


</body>
</html>