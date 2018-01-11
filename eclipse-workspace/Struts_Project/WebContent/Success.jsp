<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
    
   <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
   <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
  
  
  <%
  	String path = request.getContextPath();
  %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>首页</title>
</head>
<body>
	Welcome, ${loginUser.fullName}
	<hr>
	<a href="<%=path%>/order.do?action=list">订餐</a>|<a href="<%=path%>/order.do?action=list">查询订餐</a>

</body>
</html>