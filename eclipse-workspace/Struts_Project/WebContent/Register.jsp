<%@ page language="java" contentType="text/html;charset=gbk"
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
${registerInfo }
 	<html:form action="register">
		<table>
				<tr>
					<td>��¼�� </td>
					<td><html:text property="name"></html:text><html:errors property="name" /></td>
				</tr>
				<tr>
					<td>��¼����</td>
					<td><html:password property="password"></html:password><html:errors property="password" /></td>
				</tr>
				<tr>
					<td>�ظ�����</td>
					<td><html:password property="repassword"></html:password><html:errors property="repassword" /></td>
				</tr>
				<tr>
					<td>��ʵ���� </td>
					<td><html:text property="fullName"></html:text><html:errors property="fullName" /></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit>ע��</html:submit></td>
				</tr>
		</table>
	</html:form>

</body>
</html>