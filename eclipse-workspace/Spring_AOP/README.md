# AOP

AOP相当于struts中的filter，主要也是用来拦截。
使用代理来操作AOP。

切面：多个业务对象的程序独立出来的模块化，该模块可以无侵入式的继承到业务对象当中。比如：事务、日志、权限。纵向操作。
通知：切面的具体实现，如记录日志、验证权限。有各种类型，包括 before、after、throw。
连接点：通知执行的时机，如：方法调用。
切入点：切入点是感兴趣的连接点。通知和一个切入点表达式关联，并在满足这个切入点的连接点上运行。
目标：被代理的对象。或者被通知对象。
AOP代理：具体实现。代理对象。AOP代理可以是JDK动态代理，或者CGLIB代理。
织入：代理对象和被代理对象如何联系在一起。
AOP最底层的还是代理。
代理类和被代理类继承并实现同一个接口，并且他们之间有一个关联关系。

## Spring AOP Annotation 实现方式。

aspectjrt.jar、aspctkwaver.jar、aopaliance.jar、 spring-aspects.jar


## Spring AOP API
Advice是实现了Aspect的真正逻辑，具体来说就是java的一个类或一个方法。

Before advice ：会在目标对象的方法执行之前被调用。需要实现的接口是:MethodBeforeAdvice。
Spring A类依赖B类，主要是依赖的接口。所以spring中主要操作的是接口。

Before要实现MethodBeforeAdvice接口，实现内部的before方法。
在bean.xml中通过ProxyFactoryBean实现代理。
property: proxyInterfaces 为代理的接口。target 指代理的哪一个。引入上面的dao。interceptoreNames 拦截，内部是list，拦截器就是上面的操作代理类。

------
执行之后After advice ，执行AgterReturningAdvice，第一个参数表示返回值。
------
around advice,会在目标对象的方法执行前后被调用。需要实现MethodInterceptor,通过arg.procceed()，被代理的方法才会被调用。

------
Throw advice,标识接口，没有定义任何方法。afterThrowing


AOP主要实现的就是拦截。
