## struts2中action调用方式(使用struts2.5.13)
  **此处坑太多，2.3升到2.5之后改变太多**

开启调试模式：
```xml
<constant name="struts.devMode" value="true"/>
```

前两种都需要开启动态调用
```xml
<constant name="struts.enable.DynamicMethodInvocation" value="true"/>
```

### 1.使用ActionName!methodName.action调用

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">

<struts>
	<constant name="struts.enable.DynamicMethodInvocation" value="true"/>
	<constant name="struts.devMode" value="true"/>
	<package name="example" namespace="/" extends="struts-default">
		<!-- <global-allowed-methods>login</global-allowed-methods> -->
		<action name="user" class="com.zyy.action.UserAction">
			<result name="loginOK">/Login.jsp</result>
			<result name="registerOK">/Register.jsp</result>
			<allowed-methods>regex:.*</allowed-methods> <!--允许以*通配符的方式访问方法-->
		</action>

	</package>
</struts>
```

首先 struts.xml部分的头部修改 需要修改为上面的这种2.5的。
运行起来结果报错：Method login for action user is not allowed!

**这是因为 struts2.5 为了提升安全性，添加了 allomethod 这么个玩意**

解决方案：
1.package包下增加		<!--<global-allowed-methods>login</global-allowed-methods> -->
2.在action下增加 <!-- <allowed-methods>regex:.*</allowed-methods> -->

jsp中的调用方式:  
``` xml
<a href="<%=path %>/user!login.action">login</a>|<a href="<%=path %>/user!register.action">Register</a> -->

```

-----------------------------------------------------------------

## 2.使用多个action

```xml
<package name="example" namespace="/" extends="struts-default">
		<action name="userLogin" class="com.zyy.action.UserAction" method="login">
			<result name="loginOK">/Login.jsp</result>
		</action>

		<action name="userRegister" class="com.zyy.action.UserAction" method="register">
			<result name="registerOK">/Register.jsp</result>
		</action>
	</package>
```

配置多个action对应一个aciton，name不同，调用时根据method区别对应调用的是哪个方法

jsp中的调用方式：
```xml
<a href="<%=path %>/userLogin.action">login</a>|<a href="<%=path %>/userRegister.action">Register</a>
```

-------------------------------------------------------------------------------

## 3.使用通配符调用

通过调用*Action.action 将通配符解析到的字符传到method去使用,例:loginAction.action，method=login
```xml
<package name="example" namespace="/" extends="struts-default">
<!-- 		<global-allowed-methods>login</global-allowed-methods> -->
		<action name="*Action" class="com.zyy.action.UserAction" method="{1}">
			<result name="loginOK">/Login.jsp</result>
			<result name="registerOK">/Register.jsp</result>
			<allowed-methods>regex:.*</allowed-methods>
		</action>
	</package>
```
