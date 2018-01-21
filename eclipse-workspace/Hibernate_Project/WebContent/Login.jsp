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
<title>Insert title here</title>
</head>
<body>
<h1>欢迎使用JAVA技术论坛</h1>
<hr>
${loginInfo}
	<a href="<%=path %>/Register.jsp">点击注册</a>
	<html:form action="login">
		<table>
			<tr>
					<td>用户名</td>
					<td><html:text property="username"></html:text><html:errors property="username" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><html:password property="password"></html:password><html:errors property="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit>登录</html:submit></td>
				</tr>
		</table>
	</html:form>

</body>
</html>