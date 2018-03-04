# Spring IOC

## 1.使用IOC容器管理Bean
BeanFactory、ApplicationContext 并且后者继承于前者。
IOC通过上面两个接口来实现的。
容器是用来读取Bean的定义、管理对象的初始化和生产、以及对象之间的依赖关系。

ApplicationContext实现类:
·ClassPathXmlApplicationContext

```java
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");//参数也可以用数组String[] {"beans1.xml", "beans2.xml"}
```

Bean的标识就是配置中的id,可以使用name属性或者<alias>来为bean指定别名

调用过程getbean其实就是在使用new调用构造方法。并且调用的默认构造函数。

当采用静态工厂方法创建bean时，除了需要指定class属性外，还需要通过factory-method属性来指定创建bean实例的工厂方法。
```xml
<bean id="exampleBean" class="example.exampleBean" factory-method="createInstance" />
······注意:createInstance方法必须是一个静态方法。
```

在Spring中，从容器中获得的实例默认都是单例的。将singleton改成false，就不是单例模式了，就是多例模式了。或者将scope属性设置成prototype.
单例：
```java
private Stu(){}
private static Stu instance = new Stu();//静态对象，所有属性是共享的。
public static Stu getstance(){return instance;}
```

---------------------
设值注入：bean里面配置的属性，必须有setter方法。并且Bean定义文件中有该属性的设置。
构造方法注入：bean中属性使用<contructor-arg>,并且必须有构造方法。
          可以再构造方法中增加索引操作。(比如有2个index).
          还可以在后面增加type类型type="java.lang.String"
值属性：操作使用name value操作。
-------
空值null:某个属性可以为null,赋值为value=null. <property name="name"><null/></property>
空字符串:<property name="name"><value></value></property>

### 引用属性
就是在property中使用ref。该元素用来将bean中指定的属性的值设置为对容器中的另外一个bean的引用。条件是相同的定义文件或不同的定义文件中都可以使用。
如果不在本文件中，需要使用<ref bean="引用的配置文件"/>。相同文件中还可以使用<ref local=""/>,如果是第一种就是在另外一个文件中。

两个java bean有几成关系了，可以用 <ref parent=""/>.

### 集合对象
属性使用的是集合：<list>、<set>...
<property name="someList">
<list>
<value>one</value>
<value>two</value>
//还可以是 <ref bean=""/>
</list>
set的表现形式跟list相同。
map的有点区别:
```xml
<map>
<entry>    //一项一项的
  <key><value>1</value></value>
  <value>one</value>
</entry>
<entry>    //一项一项的
  <key><value>2</value></value>
  <value>two</value>
</entry>
</map>
```
map集合遍历使用keySet()返回set类型的keys,使用iterator进行遍历keys.iterator.
