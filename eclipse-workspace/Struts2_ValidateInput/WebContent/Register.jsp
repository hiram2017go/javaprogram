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
			alert("�û�������Ϊ��");
			f.username.focus();
			return;
		}
		
		if(pw == null || pw == ""){
			alert("���벻��Ϊ��");
			f.password.focus();
			return;
		}
	}
		
	</script>
</head>
<body>

	<s:form action="register.action" validate="true">
		<s:textfield name="username" label="�û�����"></s:textfield>  <!-- ���Զ����һ��table -->
		<s:password name="password" label="�û�����"></s:password>
		<s:textfield name="age" label="����"> </s:textfield>
		<s:textfield name="url" label="������ҳ"> </s:textfield>
		<s:textfield name="birthday" label="��������"> </s:textfield>
		<s:textfield name="email" label="Email"> </s:textfield>
		
		<!-- //��һ�ֿͻ�����֤
		<input type="button" value="ע��" onclick="validate()"> -->
				
		<s:submit value="ע��"></s:submit>
	</s:form>

</body>
</html>