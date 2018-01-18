<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
  
     <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>

	<html:form action="dic?action=add" method="post">
		类型:<html:select property="category">
				<html:option value="M">专业</html:option>
				<html:option value="R">区域</html:option>
				<html:option value="P">职位</html:option>
			</html:select><br>
			名称：<html:text property="name"></html:text><br>
			<html:submit>添加</html:submit>
	</html:form>

</body>
</html>