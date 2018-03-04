<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
     <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
	<%
		String path = request.getContextPath();
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>回复详情页</h1>   <a href="<%=path %>/Main.jsp">返回主页面</a>
<hr>
<table border="1">
	<tr>
		<td>问题编号</td><td>${questionDetail.id }</td><td>提问人</td><td>${questionDetail.sm.name}</td><td>提问时间</td><td>${questionDetail.createTime}</td>
	</tr>
	<tr>
			<td>问题编号</td><td colspan="5">${questionDetail.content }
	</tr>
</table>

<hr>
<h2>我来回答</h2>
	<html:form action="/answer.do?action=add">
		<table border="2">
				<tr style="display:none">
                        <td></td>
                        <td><html:text property="id" value="${questionID}"></html:text></td>
                    </tr>

				<tr>
					<td>回复内容</td>
					<td><html:textarea property="content"></html:textarea></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit>提交</html:submit></td>
				</tr>
		</table>
	</html:form>
<hr>
<table border="1">
<logic:iterate id="m" name="AnswerList">
	<tr>
		<td>编号</td><td>${m.id }</td><td>回复人</td><td>${m.sm.name}</td><td>回复时间</td><td>${m.createTime}</td>
	</tr>
		<tr>
			<td>回复内容</td><td colspan="5">${m.content}</td>
		</tr>
</logic:iterate>
</table>


</body>
</html>