package com.biz;

import com.Utils.Page;
import com.dao.BackendDao;
import com.dao.UserDao;
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
            if (userConditions.getUser_status() != null && userConditions.getUser_status() > 0){
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

}