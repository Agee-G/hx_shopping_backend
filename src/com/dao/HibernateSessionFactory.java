package com.dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static Configuration configuration;
	public static final SessionFactory sessionFactory;
	static {
		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}catch (HibernateException e){
			throw new ExceptionInInitializerError(e);
		}
	}

	public HibernateSessionFactory() { }

	public static Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
