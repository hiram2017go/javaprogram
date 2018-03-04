## struts2 输入验证

包含 客户端验证 和 服务端验证 ，手动验证 和 自动验证。

服务器端进行验证：
继承ActionSupport后调用validate()方法,对对应的字段增加错误提示：
this.addFieldError("对应字段", "显示信息");//必须用标签，否则不出现服务端异常显示

struts2中，出错后会跳到input页面。所以需要在action中增加input页面。
--------------------
### 自动验证
需要增加验证文件:名称是---ActionName-validation.xml并且放在对应类的包下。在该文件内验证项内可以增加<message key="username"></message> 就是从资源文件中获取该key的值，也可以直接加在里面。
自定义资源文化之后，需要添加常量struts.custom.i18n.resources为自定义的文件。

验证配置属性:
```xml
<validators>
 	<field name="username">
 		<field-validator type="requiredstring">
 			<message key="register.username.required"></message>
 		</field-validator>

 		<field-validator type="stringlength">
 			<param name="minLength">2</param>
 			<param name="maxLength">10</param>
 			<message>用户名最小长度为2，最大长度为10</message>
 		</field-validator>
 	</field>

 	<field name="password">
 		<field-validator type="requiredstring">
 			<message key="register.password.required"></message>
 		</field-validator>
 	</field>


 	<field name="url">
 		<field-validator type="url">
 			<message>URL格式错误</message>
 		</field-validator>
 	</field>

 	<field name="age">
 		<field-validator type="int">
 			<param name="min">1</param>
 			<param name="max">150</param>
 			<message>年龄最小1，最大150</message>
 		</field-validator>
 	</field>

 	<field name="email">
 		<field-validator type="email">
 			<message>email格式错误</message>
 		</field-validator>
 	</field>


 </validators>
```

客户端自动验证，在form 标签action属性后增加validate=true.
