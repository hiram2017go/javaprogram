<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
    
    <%@ taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<script type="text/javascript">
	
	function validate(){
		var f = document.forms[0];
		var un = f.username.value;
		var pw = f.password.value;
		
		if(un == null || un == ""){
			alert("用户名不能为空");
			f.username.focus();
			return;
		}
		
		if(pw == null || pw == ""){
			alert("密码不能为空");
			f.password.focus();
			return;
		}
	}
		
	</script>
</head>
<body>

	<s:form action="register.action" validate="true">
		<s:textfield name="username" label="用户名称"></s:textfield>  <!-- 会自动添加一个table -->
		<s:password name="password" label="用户密码"></s:password>
		<s:textfield name="age" label="年龄"> </s:textfield>
		<s:textfield name="url" label="个人主页"> </s:textfield>
		<s:textfield name="birthday" label="出生日期"> </s:textfield>
		<s:textfield name="email" label="Email"> </s:textfield>
		
		<!-- //第一种客户端验证
		<input type="button" value="注册" onclick="validate()"> -->
				
		<s:submit value="注册"></s:submit>
	</s:form>

</body>
</html>