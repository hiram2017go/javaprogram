<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
  
 <% String path= request.getContextPath(); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function invoke(method){
		var f = document.forms[0];
		f.action="<%=path %>/customer.do?action="+method;
		f.submit();
	}
</script>

<body>
欢迎使用Struts框架
<br>
<html:form action="/customer.do">
	<table border="0">
		<tr>
			<td>UserName:</td>
			<td><html:text property="username"></html:text></td>
		</tr>
		<tr>
			<td>UserEmail</td>
			<td><html:text property="email"></html:text></td>
		</tr>
		<tr>
			<td colspan="2" align="center"> 
			<!-- <input type="submit" value="save">  -->
			<%-- <html:submit>提交</html:submit> --%>
			<input type="button" value="保存" onclick="invoke('update')" />
			</td>
		</tr>
	</table>

</html:form>
</body>
</html>