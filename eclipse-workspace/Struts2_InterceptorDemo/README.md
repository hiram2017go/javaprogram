## 使用拦截器实现登录认证demo

1.登录保存session。
2.通过访问welcome.jsp页面，该页面执行的action被绑定了拦截器，该拦截器类似于servlet中的filter,验证是否已经登录，如果已经登录，就继续执行action相关内容，如果没有登录则执行跳到 登录页。

struts.xml配置
```xml
<struts>
	<constant name="struts.devMode" value="true"/>
	<package name="interceptordemo" namespace="/" extends="struts-default">

		<interceptors>
			<interceptor name="checklogininterceptor" class="com.zyy.interceptor.LoginInterceptor"/>
		</interceptors>

		<global-results>
			<result name="login">/Login.jsp</result>
			<result name="success">/Success.jsp</result>
		</global-results>

		<action name="login" class="com.zyy.action.LoginAction">
			<result name="input">/Login.jsp</result>
		</action>

		<action name="welcome" class="com.zyy.action.WelcomeAction">
			<interceptor-ref name="defaultStack" />
			<interceptor-ref name="checklogininterceptor" />
		</action>

	</package>

</struts>
```
