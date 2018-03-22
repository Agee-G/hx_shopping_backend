package com.Utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Txm on 22/03/2018.
 */
public class HibernateUtil {
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

    public HibernateUtil() {

    }
    public static Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
}
