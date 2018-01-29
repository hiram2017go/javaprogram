package com.zyy.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.zyy.spring.Computer;
import com.zyy.springtest.HelloWorld;

public class Tester {
	
	public static void main(String[] args) {
		
		//Resource r = new ClassPathResource("beans.xml");
		//BeanFactory factory = new XmlBeanFactory(r);   //ÒÑ¹ýÆÚ
	    @SuppressWarnings("resource")
		BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");  
		HelloWorld hw = (HelloWorld) factory.getBean("hw");
		String result = hw.Hello();
		System.out.println(result);
		
		Computer c = (Computer) factory.getBean("computer");
		c.read();
		c.write();
	}

}
