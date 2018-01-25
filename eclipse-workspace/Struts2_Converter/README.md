## 自定义类型转换
### 1.局部自定义类型转换
对应的类型转换设置properties放在对应的包下:
```
*Action-conversion.properties
```
里面内容为  属性=类型转换器

### 2.全局自定义类型转换
名称：xwork-conversion.properties  内容:属性类型=类型转换器类
可以放在src全局目录下


------------------------------------
### 3.使用struts自己的类型转换，并使用对应方法进行转换
```java
StrutsTypeConverter 继承该类去处理
```

### 4.自动类型转换

<result name="input">/TestError.jsp</result> <!--  类型转换出错之后必须跳回input页面，这个input必须加 -->

```xml
<action name="register" class="com.zyy.erraction.RegisterErrorAction">
			<result name="input">/TestError.jsp</result> <!--  类型转换出错之后必须跳回input页面，这个input必须加 -->
		</action>
```

struts中会存在拦截器，在struts-default.xml配置文件中有个拦截器ConversionError，使用这个处理。自动的页面提示信息，在xwork包下有个xwork-message.properties
为了使用自定义的中文，可以在本地进行配置进行国际化.覆盖常量。
