<%@ page language="java" import="java.util.*,com.zyy.bean.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
  <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
  <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
  <%
  	String path = request.getContextPath();
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stuts标签</title>
</head>
<%
	request.setAttribute("age", 20);
	request.setAttribute("greeting", "hello, Struts!");
	
	List list = new ArrayList();
	for(int i = 0 ; i< 10; i++){
		Person per = new Person(i, "position"+i);
		list.add(per);
	}
	
	request.setAttribute("LIST", list);
%>

<body>

<logic:equal value="20" name="age">这里是年龄20</logic:equal>
<hr>
<bean:write name="age"/>
<hr>

<logic:match value="hello" name="greeting">哈哈哈哈</logic:match>
<hr>

<html:select property="position">
	<html:options collection="LIST" property="id" labelProperty="name"/>
</html:select>

</body>
</html>