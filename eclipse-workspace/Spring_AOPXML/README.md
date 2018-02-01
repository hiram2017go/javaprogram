# Spring AOP Xml配置

切面、切入点、声明通知(Before、After。。。)
配置文件中，所有切面和通知器都必须定义在<aop:config>
<aop:aspect ref="哪一个切面(logBeforeAdvice)">

同样需要引入Annnoation注解的aspect相关包。

beans.xml配置文件
```xml
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:context="http://www.springframework.org/schema/context" xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop" xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd    
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd    
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">

  <aop:config>
  	<aop:aspect ref="logBeforeAdvice"> <!-- 声明一个切面 -->
  		<aop:pointcut expression="execution(* com.zyy.dao.UserDao.*(..))" id="pc"/>  <!-- 声明一个切入点 -->
  		<aop:before method="before" pointcut-ref="pc"/>   <!-- 声明通知 -->
  	</aop:aspect>
  	<aop:aspect ref="logAfterAdvice"> <!-- 声明一个切面 -->
  		<aop:pointcut expression="execution(* com.zyy.dao.UserDao.*(..))" id="pc2"/>  <!-- 声明一个切入点 -->
  		<aop:after method="afterReturning" pointcut-ref="pc2"/>   <!-- 声明通知 -->
  	</aop:aspect>
  </aop:config>

   <bean id="userDao" class="com.zyy.dao.impl.UserDaoImpl"/>
   <bean id="logBeforeAdvice" class="com.zyy.aopapi.LogBeforeAdvice" />
   <bean id="logAfterAdvice" class="com.zyy.aopapi.LogAfterAdvice"/>

   <bean id="logAroundAdvice" class="com.zyy.aopapi.LogAroundAdvice" />
   <bean id="logThrowAdvice" class="com.zyy.aopapi.LogThrowAdvice" />


</beans>
```

相关java代码
比如around:
```java
public class LogAroundAdvice{

	Logger logger = Logger.getLogger(this.getClass().getName());

	public Object invoke(ProceedingJoinPoint pjp) throws Throwable {


		logger.log(Level.INFO,"delete before######################################");
		pjp.proceed();
		logger.log(Level.INFO, "delete after######################################");

		return null;

	}
}
```
