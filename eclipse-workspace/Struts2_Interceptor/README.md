## struts2 中的拦截器 及动态代理 和静态代理

struts 理解为一个空的容器。通过拦截器实现了容器中的内容，params拦截器获取参数将参数传递给action中的属性。
-----------------------

1.静态代理 （比较麻烦，每个类都要去加，会搞成类爆炸）
2.代理类和被代理类需要继承同一个接口

//1.代理类和被代理类要实现同一个接口
//2.代理类和被代理类有一种关联关系(需要知道代理的是谁,---厂家代理的是哪家的产品)

--------------------------

动态代理，继承接口InvocationHandler
DynamicProxy implements InvocationHandler

1.代理绑定后，调用了实例中的delete方法，会自动调用 invoke方法。
2.动态代理，可以动态实现绑定多个类


---------------------
反射:
Class cls = Class.forName('com.zyy.bean.Person');根据类名返回一个自描述类
打印输出cls,就是com.zyy.bean.Person类
Person per = cls.newInstance();//通过自描述类型获取Persoon类
得到某个方法Method m = cls.getMethods("参数名"，"参数");// 也可以传递参数得到特定的方法,第一个参数方法名称，第二个表示方法中的参数.返回是个Method
Object obj = m.invoke("哪一个对象","调用参数的时候要不要传参数");//动态调用，并传递需要的参数
cls.getFiled();//获取属性

struts-default.xml 中 interceptor 全是拦截器
----------------------
拦截器：
1.定义一个类实现Interceptor接口，也可以继承AbstractInterceptor
2.实现intercept方法。
3.自定义拦截器，需要在struts.xml的对应action中ref name="defaultstack" 。
4.在拦截器中使用ai.invoke()进行回调action中的execute方法。
5.拦截器中执行成功了可以return ai.invoke（）跳回对应的action中继续操作。
