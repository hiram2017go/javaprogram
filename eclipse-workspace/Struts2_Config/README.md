## struts2 相关配置

最近在做项目开发过程中犯了一个很低级的错误，在这里列举出来，供大家参考借鉴：我希望通过Url请求一个Action，最终通过服务器的处理能得到一个Json串，所以我在Url中体现这一特点，将action的扩展名写为xxaction.json,在web.xml 中将struts2过滤设置成了全部拦截,代码如下:

<filter>
<filter-name>struts2</filter-name>
<filter-class> org.apache.struts2.dispatcher.FilterDispatcher
</filter-class>
</filter>

<filter-mapping>
<filter-name>struts2</filter-name>
<url-pattern>/*</url-pattern>
</filter-mapping>


  最后在采用这种方式访问action的时候，页面就抛出404错误，找不到服务器资源。朋友看了后，使用.action作为Actin的扩展名，就正常访问了。

  原因很简单：当struts2的"url-pattern"设置为"/*"时,此时Struts2的扩展名就默认为.action，所以使用.json这个扩展名就会访问不到。如果任然坚持使用.json这个扩展名，有三种发放来更改Struts2 Actin的扩展名。

方法一：

  配置struts.xml 文件内容：

<struts>
<constant name="struts.action.extension" value="json" />
//注意这里
<package name="default" extends="struts-default" namespace="/">
<action name="helloword" class="com.test.HelloWord">
<result name="success">/test/helloWord.jsp</result> </action>
</package>
</struts>


方法二：

 在struts.properties 文件中加入一行配置信息：
  struts.action.extension=json

方法三：

 在web.xml文件中给filter加上init-param属性，代码如下所示

<filter>
<filter-name>struts2</filter-name>
<filter-class> org.apache.struts2.dispatcher.FilterDispatcher
</filter-class>
<init-param>
<param-name>struts.action.extension</param-name>
<param-value>json</param-value>
</init-param>
</filter>
<filter-mapping>
<filter-name>struts2</filter-name> <url-pattern>*.json</url-pattern>
</filter-mapping>


 注意： 以上所有方法，需要注意的是action的扩展名更改了之后，<url-pattern>*.json</url-pattern>，此处的配置要么是"/*",要么与更改之后的 扩展名一致。若配置不一致，例如配置为"*.html",当访问时的扩展名为html时，能通过Struts2的过滤，但是会报404错误；当访问时扩展名为json时，Struts2的过滤都不能通过。

 -------------------------------------------------------

 <result name="success" type="plainText">/Success.jsp</result>  <!-- type位显示类型 -->
 其中type表示返回的类型.
------------------------------------------------
ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();   /*使用map的put加入session，不与serverlet耦合.*/
			session.put("sessionname", "hahahahha");
