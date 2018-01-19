package com.zyy.test;


import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.single1to1bean.Card;
import com.zyy.single1to1bean.Citizen;
import com.zyy.singlemto1bean.Customer;
import com.zyy.singlemto1bean.Orders;
import com.zyy.twoway1to1bean.Card2;
import com.zyy.twoway1to1bean.Citizen2;
import com.zyy.twowaymto1bean.Customer2;
import com.zyy.twowaymto1bean.Orders2;
import com.zyy.util.HibernateUtil;

public class Tester {

	public static void main(String[] args) {
		
		/*Customer c  = new Customer();
		c.setEmail("54300021@30057.com");
		c.setName("hahaha");
		save(c);*/
		
		/*
		Customer c = (Customer)get(Customer.class, new Integer(1));
		Orders o = new Orders();
		o.setName("Cook");
		o.setOrderNumner("b-002");
		o.setCustomer(c);
		save(o);*/
		
		//对象之间的导航 (有订单了，可以从订单汇总获取到用户.)--单向关联。
		/*Orders o = (Orders)get(Orders.class,new Integer(1));
		Customer c = o.getCustomer();
		System.out.println(c.getEmail());*/
		
		/*//获取双向关联的mto1
		Customer2 c2 = (Customer2)get(Customer2.class, new Integer(1));
		Set set = c2.getOrders();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Orders2 o2 = (Orders2)it.next();
			System.out.println(o2.getCustomer().getName()+":"+o2.getName()+":"+o2.getOrderNumner());
		}*/
		
		//以下为一对一映射功能测试
		//1.添加用户信息
		/*Citizen citizen = new Citizen();
		citizen.setName("tom");
		save(citizen);*/
		
		//2.添加身份证信息
		/*Card card = new Card();
		Citizen citizen = (Citizen)get(Citizen.class, new Integer(4));
		
		card.setSerial("111111111");
		card.setCitizen(citizen);
		save(card);*/
		
		//一对一双向映射
		/*Card2 c2 = new Card2();
		c2.setSerial("9090909099");
		
		System.out.println("***********cascade=update不支持修改citizen2时更新card2.*************");
		Citizen2 ci2 = new Citizen2();		
		ci2.setName("lucy");
		
		ci2.setCard(c2);
		
		save(ci2);
		System.out.println("-------- --------------");*/
		
		
		Citizen2 citizen2 = (Citizen2)get(Citizen2.class, new Integer(3));
		
		Card2 card2 = citizen2.getCard();
		System.out.println("serial:"+card2.getSerial());
		
	}
	
	static void save(Object o) {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();
		
		try {
			session.save(o);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		}finally {
			session.close();
		}
	}
	
	static Object get(Class cla,Integer id) {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		
		try {
			return session.get(cla, id);
		} catch (Exception e) {
		}finally {
			session.close();
		}
		return null;
	}

}
