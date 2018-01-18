package com.zyy.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Clob;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyy.bean.User;
import com.zyy.util.HibernateUtil;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void save() {
		
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();
		
		InputStream in = null;
		
		try {
			User u = new User();
			in = new FileInputStream("F:\1.jpg");
			
			/*Blob pic = Hibernate.createBlob(in);
			Clob resume = Hibernate.createClob("this is a resume!");*/
			
			/*
			 * hibernate升级到hibernate4之后，上面的方法被弃用了。
			 
			byte[] fileArray = org.springframework.util.FileCopyUtils.copyToByteArray(file);  
			cardInfo.setPhotoFile(fileArray);  */
			session.save(u);
			tran.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();
		}
		
	}
	
	public void get() {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		
		User u = (User)session.get(User.class, new Integer(1));
		Blob pic = u.getPic();
		
		byte[] buffer;
		OutputStream out;
		try {
			buffer = pic.getBytes(1, (int) pic.length());
			out = new FileOutputStream("c:\\temp.jpg");
			out.write(buffer);
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
