<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎注册java技术论坛<br>
<hr>
${registerInfo}
<html:form action="register">
		<table>
				<tr>
					<td>用户昵称： </td>
					<td><html:text property="name"></html:text><html:errors property="name" /></td>
				</tr>
				<tr>
					<td>用户密码：</td>
					<td><html:password property="password"></html:password><html:errors property="password" /></td>
				</tr>
				<tr>
					<td>重复密码：</td>
					<td><html:password property="repassword"></html:password><html:errors property="repassword" /></td>
				</tr>
				<tr>
					<td>真实姓名： </td>
					<td><html:text property="fullName"></html:text><html:errors property="fullName" /></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit>注册</html:submit></td>
				</tr>
		</table>
	</html:form>
</body>
</html>