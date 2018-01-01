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
<script type="text/javascript">
	function del(){
		if(confirm("你确定要删除?")){
			var f = document.forms[1];
			f.action = "<%=path %>/CollectionServlet?action=delete";
			f.submit();
		}else{
			return;
		}
	}

</script>

<body>

	<form action="<%=path %>/CollectionServlet?action=save" method="post">

	<table border=0>
		<tr>
			<td>Name:</td>
			<td> <input type="text" name="name"> </td>
		</tr>
		
		<tr>
			<td>Url:</td>
			<td> <input type="text" name="url" value="http://"> </td>
		</tr>		
		
		<tr>
			<td colspan="2" algin="center"> <input type = "submit" value="Save"> </td>
		</tr>
	</table>
	</form>
	<hr>
<%-- 	<c:out value="world"></c:out> --%>
<form action="" method="post">
	<c:forEach var="per" items="${CL }">
 	 ${per.id} ${per.name} 
 	  <a href="${per.url}"> ${per.url}</a> 
 	  
 	  <a href="<%=path %>/CollectionServlet?action=get&id=${per.id}">edit</a>
 	  
 	  <input type="checkbox" name="ids" value="${per.id }">
 	<br>
 </c:forEach>
 <input type="button" value="Delete" onclick="del()">
	</form>
</body>
</html>