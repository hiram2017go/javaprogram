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
${tip} | <a href="<%=path %>/Register.jsp">���ע��</a> <br> 
	<form name="f1" id = "f1" action="login.action" method="post">
		<table border="0">
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="name" id="name"/></td>
			</tr>
			<tr>
				<td>Passwprd:</td>
				<td><input type="password" name="password" id="password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>