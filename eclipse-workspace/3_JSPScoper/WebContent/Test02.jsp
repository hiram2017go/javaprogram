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
		String UserName = (String)session.getAttribute("session_name");
		out.println(UserName + "</br>");
		
		String requestName = (String)request.getAttribute("request_name");
		out.println(requestName + "</br>");
		
		String aplicationName = (String)application.getAttribute("application_name");
		out.println(aplicationName + "</br>");
		
		
		
		String realPath = application.getRealPath("upload");
		out.println(realPath);
	%>

</body>
</html>