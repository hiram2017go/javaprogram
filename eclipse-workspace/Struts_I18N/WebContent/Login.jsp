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
<title><bean:message key="login.title"/></title>
</head>
<body>

<a href="<%=path %>/login.do?l=zh&c=CN">中文</a>|<a href="<%=path %>/login.do?l=en&c=US">英文</a>

<html:form action="/login.do">
<table>
	<tr>
		<td><bean:message key="login.username" /></td>
		<td><html:text property="username"></html:text></td>
	</tr>
	<tr>
		<td><bean:message key="login.password"/></td>
		<td><html:password property="password"></html:password></td>
	</tr>
	<tr>
		<td colspan="2"><html:submit></html:submit></td>
	</tr>
</table>

</html:form>

</body>
</html>