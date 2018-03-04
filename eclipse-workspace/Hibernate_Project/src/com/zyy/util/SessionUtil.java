package com.zyy.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	
	private static String CONFIG_FILE_LOCATION="/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Configuration configuration = new Configuration();
	private static org.hibernate.SessionFactory sessionFactory;
	private static String configFile = CONFIG_FILE_LOCATION;
	
	private SessionUtil() {
	}
	
	public static Session getSession() throws HibernateException {
		Session session = (Session)threadLocal.get();
		
		if(session == null ) {
			rebuildSessionFactory();
		}
		session = (sessionFactory != null) ? sessionFactory.openSession() : null;
		threadLocal.set(session);
		
		return session;
	}
	
	/*
	 * Rebuild hibernate session factory
	 */
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%");
			e.printStackTrace();
		}
	}
	
	public static org.hibernate.SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void setConfigFile(String configFile) {
		SessionUtil.configFile = configFile;
		sessionFactory = null;
	}
	
	public static void closeSession() throws HibernateException {
		Session session = (Session)threadLocal.get();
		threadLocal.set(null);
		
		if(session != null) {
			session.close();
		}
	}

}
