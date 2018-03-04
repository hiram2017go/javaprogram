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
			alert("ÓÃ»§Ãû²»ÄÜÎª¿Õ");
			f.username.focus();
			return;
		}
		
		if(pw == null || pw == ""){
			alert("ÃÜÂë²»ÄÜÎª¿Õ");
			f.password.focus();
			return;
		}
	}
		
	</script>
</head>
<body>

	<s:form action="register.action" validate="true">
		<s:textfield name="username" label="ÓÃ»§Ãû³Æ"></s:textfield>  <!-- »á×Ô¶¯Ìí¼ÓÒ»¸ötable -->
		<s:password name="password" label="ÓÃ»§ÃÜÂë"></s:password>
		<s:textfield name="age" label="ÄêÁä"> </s:textfield>
		<s:textfield name="url" label="¸öÈËÖ÷Ò³"> </s:textfield>
		<s:textfield name="birthday" label="³öÉúÈÕÆÚ"> </s:textfield>
		<s:textfield name="email" label="Email"> </s:textfield>
		
		<!-- //µÚÒ»ÖÖ¿Í»§¶ËÑéÖ¤
		<input type="button" value="×¢²á" onclick="validate()"> -->
				
		<s:submit value="×¢²á"></s:submit>
	</s:form>

</body>
</html>