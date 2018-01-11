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
<title><bean:message key="login.title" /></title>
</head>
<body>
${loginInfo } 
	<a href="<%=path %>/Register.jsp">注册用户</a>|<a href="<%=path %>/i18n.do?l=zh&c=CN">中文</a>|<a href="<%=path %>/i18n.do?l=en&c=US">English</a>
	<html:form action="login">
		<table>
				<tr>
					<td><bean:message key="login.username"/> </td>
					<td><html:text property="username"></html:text><html:errors property="username" /></td>
				</tr>
				<tr>
					<td><bean:message key="login.password"/></td>
					<td><html:password property="password"></html:password><html:errors property="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit><bean:message key="login.submit"/></html:submit></td>
				</tr>
		</table>
	</html:form>

</body>
</html>