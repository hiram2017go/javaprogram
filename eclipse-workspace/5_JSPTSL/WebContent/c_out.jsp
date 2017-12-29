<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>

 <%
 	int age = 30;
 	request.setAttribute("age", new Integer(age));
 %>

<c:out value="1111111"></c:out>
	
	<c:out value="${age }"></c:out>
	<br>
	
 <c:if test="${age < 20}">
 	gogogo
 </c:if>
  <hr>
 <c:set value="zyy" var="name" scope="request"></c:set>
 <c:out value="${name }"></c:out>
 
 <hr>
 <c:set var="age">100</c:set>
 <c:out value="${age}"></c:out>
 
 
 <%-- <jsp:useBean id="per" class="com.amaker.bean.Person"/>
 <c:set target="${per }" property="age" value="30"></c:set>
 <c:set target="${per }" property="name" value="tomcat"></c:set>
 
 <c:out value="${per.age}"></c:out>
 <c:out value="${per.name}"></c:out> --%>
 
</body>
</html>