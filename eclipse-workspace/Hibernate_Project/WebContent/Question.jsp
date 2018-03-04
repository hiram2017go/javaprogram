<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎使用java技术论坛，请输入你想提问的题目
<hr>
	<html:form action="/question.do?action=add">
		<table>
				<tr>
					<td>问题关键字</td>
					<td><html:text property="questionKey"></html:text><html:errors property="questionKey" /></td>
				</tr>
				<tr>
					<td>问题类型</td>
					<td>
						<html:select property="questionTypeID">
							<html:options collection="QuestionTypeList" property="id" labelProperty="name"/>
						</html:select></td>
				</tr>
				<tr>
					<td>问题内容</td>
					<td><html:textarea property="content"></html:textarea></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit>提交</html:submit></td>
				</tr>
		</table>
	</html:form>

</body>
</html>