<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8" errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Insert title here</title>
</head>
<body>
 <%!
	//public static double j = Math.random();
  	//out.println("-=-=-");//wrong
  	
  	public String Hello() {
  		//System.out.println("-=-=-");//wrong
  		return "12312312312334resert";//good
  	}
%> 

<!-- 表达式 -->
<%= Hello() %>

<!-- 用《%! 也可以 -->

<%

Hello();
out.println("------===------------");//right
  /* String count = null;
	int length = count.length();    */
%>

</body>
</html>