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
		����:<html:select property="category">
				<html:option value="M">רҵ</html:option>
				<html:option value="R">����</html:option>
				<html:option value="P">ְλ</html:option>
			</html:select><br>
			���ƣ�<html:text property="name"></html:text><br>
			<html:submit>���</html:submit>
	</html:form>

</body>
</html>