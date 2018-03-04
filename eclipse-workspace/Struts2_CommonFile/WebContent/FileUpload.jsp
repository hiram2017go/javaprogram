<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form name="f1" id = "f1" action="/Struts2_CommonFile/FileServlet" method="post" enctype="multipart/form-data">
		<table border="0">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>File:</td>
				<td><input type="file" name="file"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>

</body>
</html>