package com.biz;

import com.Utils.Page;
import com.dao.BackendDao;
import com.dao.StoreApplyDao;
import com.dao.StoreDao;
import com.dao.UserDao;
import com.entity.*;
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
    private StoreApplyDao storeApplyDao = new StoreApplyDao();

    public StoreEntity findStore(String storeId){
        Transaction transaction = null;
        Session session = storeDao.currentSession();
        StoreEntity storeEntity = null;
        try{
            transaction = session.beginTransaction();
            storeEntity = storeDao.get(storeId);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return storeEntity;
    }
    public UserEntity findUser(String userId){
        Transaction transaction = null;
        Session session = userDao.currentSession();
        UserEntity userEntity = null;
        try{
            transaction = session.beginTransaction();
            userEntity = userDao.get(userId);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return userEntity;

    }
    public StoreapplyEntity findStoreApply(String storeapplyId){
        Transaction transaction = null;
        Session session = storeApplyDao.currentSession();
        StoreapplyEntity storeapplyEntity = null;
        try{
            transaction = session.beginTransaction();
            storeapplyEntity = storeApplyDao.get(storeapplyId);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return storeapplyEntity;

    }


    //管理员登陆
    public List<UserEntity> adminLogin(UserConditions userConditions){
        Transaction transaction = null;
        Session session = userDao.currentSession();
        List<UserEntity> userEntityList = null;
        try{
            transaction = session.beginTransaction();
            StringBuilder hql = new StringBuilder("from UserEntity as user where 1=1");
            hql.append(" and user.userLevel = 2");
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
        Session session = storeDao.currentSession();
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
    //用户冻结与解冻
    public void updateUserStatus(UserEntity userEntity){
        Transaction transaction = null;
        Session session = userDao.currentSession();
        try{
            transaction = session.beginTransaction();
            userDao.updateUserStatus(userEntity);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
    }
    //查找所有申诉
    public List<StoreapplyEntity> findAllApply(){
        Transaction transaction = null;
        Session session = storeApplyDao.currentSession();
        List<StoreapplyEntity> storeapplyEntities = null;
        try{
            transaction = session.beginTransaction();
            storeapplyEntities = storeApplyDao.findAllApply();
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return storeapplyEntities;
    }
    //通过storeId查找申诉
    public List<StoreapplyEntity> findApplyByStoreId(String storeId){
        Transaction transaction = null;
        Session session = storeApplyDao.currentSession();
        List<StoreapplyEntity> storeapplyEntities = null;
        try{
            transaction = session.beginTransaction();
            storeapplyEntities = storeApplyDao.findApplyByStoreId(storeId);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return storeapplyEntities;
    }
    //修改申诉状态
    public void updateApplyStatus(StoreapplyEntity storeapplyEntity){
        Transaction transaction = null;
        Session session = storeApplyDao.currentSession();
        try{
            transaction = session.beginTransaction();
            storeApplyDao.updateApplyStatus(storeapplyEntity);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
    }
}
