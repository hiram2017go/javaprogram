<%@ page language="java"  import="java.util.*,com.zyy.bean.*"  contentType="text/html; charset=UTF-8"
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
<title>用户注册</title>
</head>
<body>
<%
	List list = new ArrayList();
	for(int i = 0 ; i< 10; i++){
		Person per = new Person(i, "position"+i);
		list.add(per);
	}
	
	request.setAttribute("LIST", list);
%>
<html:form action="/register.do">
<table>
	<tr>
		<td>Username</td>
		<td><html:text property="username"></html:text><html:errors property="username" /> </td>
	</tr>
	<tr>
		<td>Password</td>
		<td><html:password property="password"></html:password><html:errors property="password" /></td>
	</tr>
	
	<tr>
		<td>Age</td>
		<td><html:text property="age"></html:text><html:errors property="age" /></td>
	</tr>
	
	<tr>
		<td>Email</td>
		<td><html:text property="email"></html:text><html:errors property="email" /></td>
	</tr>
	
	<tr>
		<td>Url</td>
		<td>
		<%-- 
			<html:text property="url"></html:text><html:errors property="url" />
		 	下面的select为StrutsTag中的验证，因为要添加Form，直接在这里用url 代替 position使用。
		--%>
		<html:select property="url">
			<html:options collection="LIST" property="id" labelProperty="name"/>
		</html:select>
		</td>
	</tr>
	<tr>
		<td colspan="2"><html:submit></html:submit></td>
	</tr>
</table>

</html:form>

</body>
</html>