package com.dao;

import com.Utils.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by Txm on 22/03/2018.
 */
public class BaseDao {
    public Session currentSession(){
        return HibernateUtil.currentSession();
    }
}
