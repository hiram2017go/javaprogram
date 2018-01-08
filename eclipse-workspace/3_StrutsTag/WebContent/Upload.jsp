<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="gbk"%>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<html:form action="/upload" enctype="multipart/form-data">
	<html:file property="file"></html:file>
	<html:submit></html:submit>
</html:form>

</body>
</html>