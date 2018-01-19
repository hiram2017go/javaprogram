package com.zyy.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.bean.User;
import com.zyy.mappingbean.Customer;
import com.zyy.mappingbean.Orders;
import com.zyy.util.HibernateUtil;


public class Tester {
	
	public static void main(String[] args) {
		
		/*User u = new User();
		u.setName("newname");
		u.setPassword("password");
		save(u);*/
		
		//List list = getList();
		
		/*Iterator it = list.iterator();
		while(it.hasNext()) {
			User u = (User)it.next();
			System.out.println("用户id:"+u.getId()+",name="+u.getName()+",pass="+u.getPassword());
			//String s = (String)it.next();
			//System.out.println("name="+s);
		}
		*/
		
		/*for(int i = 0; i < list.size(); i++) {
			User u = (User)list.get(i);
			System.out.println("用户id:"+u.getId()+",name="+u.getName()+",pass="+u.getPassword());
		}*/
		
		
		/*for(int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[])list.get(i);
			for(int j = 0; j < obj.length; j++) {
				System.out.print(obj[j]+",");
			}
			System.out.println("");
		}*/
		
		//delete();
		
		//getQuery();
		//leftJoin();
		leftEfetchJoin();
	}
	
	public static void leftJoin() {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		
		//String hql = "select c from Customer as c left join c.orders as o with c.id = o.customerId ";
		String hql = "select o from Orders as  o left join o.customer as c with o.id = 5"; //with后参数貌似没起多大作用
		Query query = session.createQuery(hql);
		//query.setString("email", "xxx");
		System.out.println("left join 搞起来......");
		List list = query.list();
		for(int i = 0; i < list.size(); i++) {
			/*Customer c = (Customer)list.get(i);
			if(c != null) System.out.print("id="+c.getId());*/
			Orders o = (Orders)list.get(i);
			System.out.println("id="+o.getId()+",name="+o.getName()+",cid="+o.getCustomer().getId());
		}
		
	}
	
	public static void leftEfetchJoin() {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		
		String hql = "from Orders as o left join fetch o.customer"; 
		Query query = session.createQuery(hql);
		System.out.println("left join 搞起来......");
		List list = query.list();
		for(int i = 0; i < list.size(); i++) {
			Orders order =(Orders)list.get(i);
			Customer customer = order.getCustomer();
			System.out.print("oid="+order.getId()+",orderno="+order.getOrderNumber()+",name="+order.getName());
			if(customer != null )
			{
				System.out.print(".不是空的:");
				System.out.println("cid="+customer.getId()+",email="+customer.getEmail());
			}
			else {
				System.out.println("空的");
			}
			System.out.println("");
		}
		
	}
	
	public static void getQuery() {
		
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		String hql = "from User";
		Query<User> query = session.createQuery(hql, User.class);
		List<User> list = query.getResultList();
		
		for(User u : list) {
			System.out.println("name="+u.getName()+":"+u.getId());
		}	
		
	}
	
	
	public static List getList() {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		/*String sql = "select new User(id,name,password) from User where id > ?";
		Query query = session.createQuery(sql);*/
		
		Query query = session.getNamedQuery("queryEqual12");
		query.setInteger("id", 12);
		
		return query.list();
	}
	
	public static void delete() {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();
		
		try {
			String sql = "delete User as u where u.id = :id";
			//String sql = "update User as u set u.name = :name where u.id = :id";
			Query query = session.createQuery(sql);
			query.setInteger("id", 5);
			query.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();
		}
		
	}
	
	public static void save(Object obj) {
		
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();
		
		try {
			session.save(obj);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();
		}
	}

}
