package com.zyy.test;

import org.hibernate.Session;

import com.zyy.bean.Contact;
import com.zyy.bean.Name;
import com.zyy.bean.User;
import com.zyy.util.HibernateUtil;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		
		System.out.println("begin.............");
		
		try {
			/*
			 * 1。
			User u = new User();
			
			u.setAddress("canton");
			u.setAge(20);
			u.setFirstname("yy");
			u.setLastname("z");
			u.setTel("1666666666");
			u.setPostcode("5130000");
			session.save(u);
			*/
			//2.使用组件插入数据
			User u2 = new User();
			u2.setAge(18);
			
			Name name = new Name();
			name.setFirstname("firstname");
			name.setLastname("lastname");
			
			Contact contact = new Contact();
			contact.setAddress("luogang");
			contact.setPostcode("510000");
			contact.setTel("1899898989");
			
			u2.setName(name);
			u2.setContact(contact);
			
			session.save(u2);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出错了:"+e.getMessage());
		}finally {
			session.close();
		}
		
		System.out.println("done!!!!!!!!!!!!!!");
	}

}
