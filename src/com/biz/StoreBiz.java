package com.biz;

import com.dao.StoreDao;
import com.entity.StoreEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 28/04/201823:38
 */
public class StoreBiz {
    private StoreDao storeDao = new StoreDao();


    public void addNewStore(StoreEntity storeEntity){
        Transaction transaction = null;
        Session session = storeDao.currentSession();
        try{
            transaction = session.beginTransaction();
            storeDao.insertNewStore(storeEntity);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
    }


}
