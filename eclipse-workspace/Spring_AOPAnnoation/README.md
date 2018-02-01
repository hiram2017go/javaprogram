# Spring AOP Annotation 实现

<aop:aspectj-autoproxy> 启动aop支持
声明一个切面：@Aspect 注解
声明一个切入点：execution...
切入点决定了连接点关注的内容，使得我们可以控制通知什么时候执行。

---------------------
Spring AOP XML 实现
切面、切入点、声明通知(Before、After。。。)
配置文件中，所有切面和通知器都必须定义在<aop:config>
<aop:aspect ref="哪一个切面(logBeforeAdvice)">

------------------------

Spring -- 全面的事务支持。
事务的抽象、事务的隔离机制。isolation:事务的隔离级别。
-------------------------
Spring JDBC核心类
JdbcTemplate类
namedParameterJdbc...
需要commons-pool.jar common-jdbc.jar、commons-collection.jar

数据库连接一spring会自动关闭，但是配置会存在一大堆。

add* ：表示以add开始的所有方法均这么处理。
proxyInterfaces:代理的接口是什么，是一个list value=com.zyy.dao.AccountDao
target:目标 ref="accountDao"
transactionManager: ref="tx" 数据源的管理器。
--------------------------------------------
注解操作小示例：
beans.xml中配置:
```xml
  <aop:aspectj-autoproxy />  <!--这一行很重要 -->

	<bean id="userDao" class="com.zyy.dao.impl.UserDaoImpl" />
	<bean id="logBeforeAdvice" class="com.zyy.aopapi.LogBeforeAdvice" />
```
代理代码内容：
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogBeforeAdvice {

	Logger logger = Logger.getLogger(this.getClass().getName());

	@Before("execution( * com.zyy.dao.UserDao.*(..))")
	public void before(){
		logger.log(Level.INFO, "delete before ...");

	}
}
```

测试实例调用：
```java
public static void main(String[] args) {
		ApplicationContext context = new  ClassPathXmlApplicationContext("beans.xml");  
		UserDao dao = (UserDao)context.getBean("userDao"); //调用自己的实例。
		dao.delete("amaker");
	}
```
----------------------------------------------------
