使用Tomcat配置hibernateJNDI数据源配置：
1.将下面内容添加都tomcat目录下的conf/content.xml内容Context下：
<Resource  name="jdbc/dstest" auth="Container"
    type="javax.sql.DataSource" 
    driverClassName="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/javadb"
    username="root" password="123456" maxActive="5"
    maxIdle="2" maxWait="10000"

 2.在项目的web.xml文件中添加：
```
  <resource-ref>
      <description>DB Connection</description>
      <res-ref-name>java:comp/env/jdbc/dstest</res-ref-name>
      <res-type>javax.sql.DataSource</res-type>
      <res-auth>Container</res-auth>
  </resource-ref>
```
  3.在hibernate.cfg.xml文件中添加
  ```
   <property name="connection.datasource">jdbc/dstest</property>
  ```
   内容表示数据源。

4.启动本地tomcat,通过浏览器访问可得到结果。
   上述方式即可配置完毕。可以使用WebContext目录下的jsp进行测试。