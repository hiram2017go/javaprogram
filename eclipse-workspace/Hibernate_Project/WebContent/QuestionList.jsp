<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
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
<h1>Java技术论坛问题列表</h1>
<hr>

<table border="1">
	<tr>
		<td>编号</td><td>提问人</td><td>提问时间</td><td>提问类型</td><td>提问内容</td><td>回复人数</td><td>操作</td>
	</tr>
	<logic:iterate id="m" name="QuestionList">
		<tr>
			<td>${m.id }</td><td>${m.sm.name}</td><td>${m.createTime}</td><td>${m.qt.name}</td><td>${m.content} </td><td>${m.answerCount}</td><td><a href="<%=path%>/answer.do?action=list&id=${m.id }">查看详情</a></td>
		</tr>
	</logic:iterate>
</table>
</body>
</html>