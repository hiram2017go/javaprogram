# Spring JDBC 相关操作

Spring -- 全面的事务支持。
事务的抽象、事务的隔离机制。isolation:事务的隔离级别。
-------------------------
Spring JDBC核心类
JdbcTemplate类
namedParameterJdbc...
需要commons-pool.jar commons-jdbc.jar、commons-collection.jar

数据库连接一spring会自动关闭，但是配置会存在一大堆。

add* ：表示以add开始的所有方法均这么处理。
proxyInterfaces:代理的接口是什么，是一个list value=com.zyy.dao.AccountDao
target:目标 ref="accountDao"
transactionManager: ref="tx" 数据源的管理器。
--------------------------------------------

AOP API方式实现
```xml
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:context="http://www.springframework.org/schema/context" xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop" xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd    
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd    
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">


        <bean id="userDao" class="com.zyy.dao.impl.UserDaoImpl">
        	<property name="jdbcTemplate" ref="jdbcTemplate"></property>
        </bean>

        <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        	<constructor-arg ref="dataSource"/>
        </bean>

        <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
        	<property name="driverClassName">
        		<value>com.mysql.jdbc.Driver</value>
        	</property>
        	<property name="url">
        		<value>jdbc:mysql://10.32.10.73:3310/spring_db</value>
        	</property>
        	<property name="username">
        		<value>root</value>
        	</property>
        	<property name="password">
        		<value>123456</value>
        	</property>
        </bean>

</beans>
```

事务使用方式:
```java
public void delete(int id) {
		DefaultTransactionDefinition td = new DefaultTransactionDefinition();
		td.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus ts = tx.getTransaction(td);

		try {
			String sql1 = "delete from usertbl where id = ? ";
			String sql2 = "delete from usertbls where id = ? ";
			jdbcTemplate.update(sql1, new Object[] {2});
			jdbcTemplate.update(sql2, new Object[] {3});

			tx.commit(ts);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出错了，回滚"+e.getMessage());
			tx.rollback(ts);
		}
	}
```

-------------------------------------------------------
Spring Aop xml配置事务 ,同样需要导入aspect相关包。
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:tx="http://www.springframework.org/schema/tx"
    default-autowire="byName"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">

       	<tx:advice id="txadvice" transaction-manager="tx"> <!-- tx:advice 中的tx为命名空间,表示事务处理。 transaction-manager关联下面的tx，执行事务控制-->
       		<tx:attributes>  <!-- 属性 -->
       			<tx:method name="deleteforxml" propagation="REQUIRED"/>  <!-- 具体方法 -->
       		</tx:attributes>
       	</tx:advice>

       	<aop:config>
       		<aop:pointcut id="pc" expression="execution(* com.zyy.dao.UserDao.*(..))"/>
       		<aop:advisor advice-ref="txadvice" pointcut-ref="pc"/> <!-- 引入切入点 -->
       	</aop:config>

        <bean id="tx" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        	<property name="dataSource" ref="dataSource"></property>
        </bean>

        <bean id="userDao" class="com.zyy.dao.impl.UserDaoImpl">
        	<property name="jdbcTemplate" ref="jdbcTemplate"></property>
        	<property name="tx" ref="tx"></property>
        </bean>

        <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        	<constructor-arg ref="dataSource"/>
        </bean>

        <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
        	<property name="driverClassName">
        		<value>com.mysql.jdbc.Driver</value>
        	</property>
        	<property name="url">
        		<value>jdbc:mysql://10.32.10.73:3310/spring_db</value>
        	</property>
        	<property name="username">
        		<value>root</value>
        	</property>
        	<property name="password">
        		<value>123456</value>
        	</property>
        </bean>

</beans>
```

---------------------------------------------------------
## Spring Aop annoation 事务处理方式
只需在配置文件中增加
```xml
  <tx:annotation-driven transaction-manager="tx"/>
  ```

  代码中在需要的方法上增加 注解头 就可以。 @Transactional(propagation=Propagation.REQUIRED)
  ```java
  @Transactional(propagation=Propagation.REQUIRED)
	public void deleteforanno() {

		String sql1 = "delete from usertbl where id = ? ";
		String sql2 = "delete from usertbl where id = ? ";
		jdbcTemplate.update(sql1, new Object[] {9});
		jdbcTemplate.update(sql2, new Object[] {8});
	}
  ```
