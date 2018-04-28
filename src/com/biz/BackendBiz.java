package com.biz;

import com.Utils.Page;
import com.dao.BackendDao;
import com.dao.StoreDao;
import com.dao.UserDao;
import com.entity.StoreConditions;
import com.entity.StoreEntity;
import com.entity.UserConditions;
import com.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 25/04/201808:20
 */
public class BackendBiz {
    private UserDao userDao = new UserDao();
    private StoreDao storeDao = new StoreDao();
    //管理员登陆
    public List<UserEntity> adminLogin(UserConditions userConditions){
        Transaction transaction = null;
        Session session = userDao.currentSession();
        List<UserEntity> userEntityList = null;
        try{
            transaction = session.beginTransaction();
            StringBuilder hql = new StringBuilder("from UserEntity as user where 1=1");
            if (userConditions.getUser_account() != null && userConditions.getUser_account().length() > 0){
                hql.append(" and user.userAccount = :user_account");
            }
            if (userConditions.getUser_password() != null && userConditions.getUser_password().length() > 0){
                hql.append(" and user.userPassword = :user_password");
            }
            userEntityList = userDao.search(hql.toString(),userConditions);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return userEntityList;
    }
    //用户信息查询
    public void findUsersByConditionsByPage(Page<UserEntity> page,UserConditions userConditions){
        Transaction transaction = null;
        Session session = userDao.currentSession();
        List<UserEntity> userEntityList = null;
        try{
            transaction = session.beginTransaction();
            StringBuilder hql = new StringBuilder("from UserEntity as user where 1=1");
            if (userConditions.getUser_account() != null && userConditions.getUser_account().length() > 0){
                hql.append(" and user.userAccount = :user_account");
            }
            if (userConditions.getUser_nickname() != null && userConditions.getUser_nickname().length() > 0){
                hql.append(" and user.userNickname like :user_nickname");
            }
            if (userConditions.getUser_totalscore() != null && userConditions.getUser_totalscore() > 0){
                hql.append(" and user.userTotalscore > :user_totalscore");
            }
            if (userConditions.getUser_status() != null && userConditions.getUser_status().length() > 0){
                hql.append(" and user.userStatus = :user_status");
            }
            page.setCount(userDao.obtainCount(hql.toString(),userConditions).intValue());
            userEntityList = userDao.search(page,hql.toString(),userConditions);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        page.setPageList(userEntityList);
    }
    //商家信息查询
    public void findStoresByConditionByPage(Page<StoreEntity> page, StoreConditions storeConditions){
        Transaction transaction = null;
        Session session = userDao.currentSession();
        List<StoreEntity> storeEntityList = null;
        try{
            transaction = session.beginTransaction();
            StringBuilder hql = new StringBuilder("from StoreEntity as store where 1=1");
            if (storeConditions.getStore_account() != null && storeConditions.getStore_account().length() > 0){
                hql.append(" and store.storeAccount = :store_account");
            }
            if (storeConditions.getStore_name() != null && storeConditions.getStore_name().length() > 0){
                hql.append(" and store.storeName like :store_name");
            }

            if (storeConditions.getStore_status() != null && storeConditions.getStore_account().length() > 0){
                hql.append(" and store.storeStatus = :store_status");
            }
            page.setCount(storeDao.obtainCount(hql.toString(),storeConditions).intValue());
            storeEntityList = storeDao.search(page,hql.toString(),storeConditions);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        page.setPageList(storeEntityList);
    }
    //商家冻结和解冻
    public void updateStoreStatus(StoreEntity storeEntity){
        Transaction transaction = null;
        Session session = userDao.currentSession();
        try{
            transaction = session.beginTransaction();
            storeDao.updateStoreStatus(storeEntity);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
    }

}
