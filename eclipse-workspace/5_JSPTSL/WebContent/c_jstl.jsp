<%@ page language="java" import="java.util.*,com.zyy.bean.*" contentType="text/html; charset=gbk"
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

 	int score = 58;
 	request.setAttribute("score", new Integer(score));

 	List list = new ArrayList();
 	list.add("A");
 	list.add("B");
 	list.add("C");
 	list.add("D");
 	list.add("E");
 	list.add("F");

 	request.setAttribute("List", list);

 	List perList = new ArrayList();

 	Person person = new Person();
 	person.setAge(10);
 	person.setName("tom");

 	perList.add(person);

 	Person person2 = new Person();
 	person2.setAge(20);
 	person2.setName("person2");

 	perList.add(person2);

 	Person person3 = new Person();
 	person3.setAge(30);
 	person3.setName("person3");

 	perList.add(person3);


 	request.setAttribute("perList", perList);
 %>

<c:out value="1111111"></c:out>

	<c:out value="${age }"></c:out>
	<br>

 <c:if test="${age < 20}">
 	gogogo
 </c:if>
  <hr>
 <c:set value="zyy" var="name" scope="request"></c:set>
 <c:out value="${name }"></c:out>  //value值就是这里显示的值

 <hr>
 <c:set var="age">100</c:set>
 <c:out value="${age}"></c:out>


 <%-- <jsp:useBean id="per" class="com.amaker.bean.Person"/>
 <c:set target="${per }" property="age" value="30"></c:set>
 <c:set target="${per }" property="name" value="tomcat"></c:set>

 <c:out value="${per.age}"></c:out>
 <c:out value="${per.name}"></c:out> --%>

 <hr>
 下面是执行c:choose
<br>
<c:choose>
	<c:when test="${score > 90}" > 成绩优秀
	</c:when>

	<c:when test="${score > 60 && score <= 90}">成绩良好</c:when>

	<c:otherwise>一般般!</c:otherwise>
</c:choose>


 <hr>
 下面操作foreach
 <br>

 <c:forEach var="l" items="${List }">
 	<c:out value="${l }"></c:out>
 </c:forEach>

 <br>

 <c:forEach var="per" items="${perList }">
 	<c:out value="${per.age }"></c:out>
 	<c:out value="${per.name }"></c:out>
 	<br>
 </c:forEach>

 <br>

 <c:forEach begin="1" end="10" var="i" step="2" varStatus="status">
 	${i } ${status.index} ${status.first} ${status.last} ${status.count} <br>

 </c:forEach>
 <br>

</body>
</html>
