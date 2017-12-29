<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="c" class="com.zyy.bean.Calculator"/>
	<jsp:setProperty name="c" property="*" />

	Result:  ${c.firstNum}${c.operator}${c.secondNum}=${c.result}

	<form action="TestCalculator.jsp" method="post">

	<table border=0>
		<tr>
			<td>First:</td>
			<td> <input type="text" name="firstNum"> </td>
		</tr>
		
		<tr>
			<td>Operator:</td>
			<td> <select name="operator">
					<option value="+">+</option>
					<option value="-">-</option>
					<option value="*">*</option>
					<option value="/">/</option>
				</select>
			 </td>
		</tr>		
		
		<tr>
			<td>Second:</td>
			<td> <input type="text" name="secondNum"> </td>
		</tr>
		
		<tr>
			<td colspan="2" algin="center"> <input type = "submit" value="开始计算"> </td>
		</tr>
	</table>
 
</form>

</body>
</html>