<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
   
   <%
   	String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+""+request.getServerPort();
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<%=path %>/CollectionServlet?action=update" method="post">
	<input type="hidden" name="id" value="${CollectionBean.id}">
	<table border=0>
		<tr>
			<td>Name:</td>
			<td> <input type="text" name="name" value="${CollectionBean.name}"> </td>
		</tr>
		
		<tr>
			<td>Url:</td>
			<td> <input type="text" name="url" value="${CollectionBean.url}"> </td>
		</tr>		
		
		<tr>
			<td colspan="2" algin="center"> <input type = "submit" value="Save"> </td>
		</tr>
	</table>
	</form>
	<hr>
	
</body>
</html>