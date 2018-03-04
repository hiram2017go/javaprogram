## 容器

1.容器：容器可以装载对象、实例化对象、配置对象之间的依赖关系。
IOC:控制反转(Inversion of Control)，依赖注入. 和DI(Dependency  Injection)，是指程序之间的依赖关系由容器动态注入，而非硬编码实现。
依赖抽象非具体。www.springframework.com 2.5

2.静态类中获取配置文件
```java
 Properties prop = new Properties();
prop.load(Tester.class.getClassLoader().getResourceAsStream("配置文件名");
Tester 为静态类，不能用this.class

```
3.spring 代码中基本无new 标识。
4.spring 中配置文件的属性会直接将属性赋值给对象。
```java
Resource r = new ClassPathResource("bean.xml");
BeanFactory factory = new XmlBeaFactory(r);
HelloWorld hw = (HelloWorld)factory.getBean("hw");//获得对象

//从3.0开始 XmlBeaFactory被拒绝使用，所以改成
BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");  
```

5.电脑中硬盘和移动硬盘都继承USB接口，所以电脑依赖USB接口就行。
配置文件中依赖(ref)谁，就读的是谁的操作(具体见代码)。

6.依赖注入方式： (1).设置注入(通过setter方法)(2).构造方法注入(3).接口注入.
