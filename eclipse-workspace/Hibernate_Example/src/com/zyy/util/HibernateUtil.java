package com.zyy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public Session getSession() {
		Configuration conf = new Configuration();
		conf.configure();
		
		SessionFactory sf = conf.buildSessionFactory();		
		Session session = sf.openSession();
		
		return session;
	}
}
