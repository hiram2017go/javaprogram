<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
    
   <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
   <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
   <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
  <%
  	String path = request.getContextPath();
  %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>��������ҳ</title>
</head>
<body>

	<html:form action="/order.do?action=add">
		<table>
				<tr>
					<td>��������</td>
					<td><html:text property="num"></html:text><html:errors property="num" /></td>
				</tr>
				<tr>
					<td>��������</td>
					<td>
						<html:select property="mealTypeID">
							<html:options collection="MealTypeSession" property="id" labelProperty="name"/>
						</html:select></td>
				</tr>
				<tr>
					<td>��ע</td>
					<td><html:textarea property="detail"></html:textarea></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit>�ύ</html:submit></td>
				</tr>
		</table>
	</html:form>
<hr>
���ж�����Ϣ<br>
<logic:iterate id="m" name="MealList">
	${m.fullName} | ${m.mealTypeName} |  ${m.num} |  ${m.total} |  ${m.orderTime} |  ${m.detail} | 
	
	<c:if test="${m.isPay == 0}">δ����</c:if>
	<c:if test="${m.isPay == 1}">����</c:if>
	
	<br>

</logic:iterate>


</body>
</html>