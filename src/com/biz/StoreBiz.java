package com.biz;

import com.dao.StoreDao;
import com.entity.StoreConditions;
import com.entity.StoreEntity;
import com.entity.StoreapplyEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 28/04/201823:38
 */
public class StoreBiz {
    private StoreDao storeDao = new StoreDao();

    public StoreEntity getStore(String id){
        Transaction transaction = null;
        Session session = storeDao.currentSession();
        StoreEntity storeEntity = null;
        try{
            transaction = session.beginTransaction();
            storeEntity = storeDao.get(id);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return storeEntity;
    }

    public int findStoreApplyCount(StoreEntity storeEntity){
        Transaction transaction = null;
        Session session = storeDao.currentSession();
        int count = 0;
        try{
            transaction = session.beginTransaction();
            count = storeDao.findStoreApply(storeEntity).intValue();
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return count;
    }


    public void addNewStoreApply(StoreapplyEntity storeapplyEntity){
        Transaction transaction = null;
        Session session = storeDao.currentSession();
        try{
            storeapplyEntity.setStoreapplyId(UUID.randomUUID().toString());
            transaction = session.beginTransaction();
            storeDao.insertNewStoreApply(storeapplyEntity);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
    }


    //添加新商家
    public void addNewStore(StoreEntity storeEntity){
        Transaction transaction = null;
        Session session = storeDao.currentSession();
        try{
            storeEntity.setStoreId(UUID.randomUUID().toString());
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
    //商家登陆
    public List<StoreEntity> storeLogin(StoreConditions storeConditions){
        Transaction transaction = null;
        Session session = storeDao.currentSession();
        List<StoreEntity> storeEntityList = null;
        try{
            transaction = session.beginTransaction();
            StringBuilder hql = new StringBuilder("from StoreEntity as s where 1=1");
            if (storeConditions.getStore_account() != null && storeConditions.getStore_account().length() > 0){
                hql.append(" and s.storeAccount = :store_account");
            }
            if (storeConditions.getStore_password() != null && storeConditions.getStore_password().length() > 0){
                hql.append(" and s.storePassword = :store_password");
            }
            storeEntityList = storeDao.search(hql.toString(),storeConditions);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return storeEntityList;
    }

    public void updateStore(StoreEntity storeEntity){
        Transaction tran = null;
        Session session = storeDao.currentSession();
        try {
            tran = session.beginTransaction();
            storeDao.updateStore(storeEntity);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }

    }


}
