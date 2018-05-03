package com.biz;

import com.dao.UserDao;
import com.entity.RemarkEntity;
import com.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/25 下午2:35
 */
public class UserBiz {
    private int code = 0;
    private UserDao userDao = new UserDao();

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public void addUser(UserEntity userEntity){
        //事务初始化
        Transaction tran = null;
        Session session = userDao.currentSession();
        UserDao userDao = new UserDao();
        try {
            //开启事务
            tran = session.beginTransaction();
            userEntity.setUserId(UUID.randomUUID().toString());
            userDao.addUser(userEntity);
            tran.commit();
            //提交事务
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }

    public String loginValid(String userAccount,String userPassword){
        String valid = "no";
        Transaction tran = null;
        Session session = userDao.currentSession();
        try{
            tran = session.beginTransaction();
            userDao.loginValid(userAccount,userPassword);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
        return valid;
    }

    public void userLogin(String userAccount,String userPassword){
        Transaction tran = null;
        Session session = userDao.currentSession();
        try{
            tran = session.beginTransaction();
            String valid = userDao.loginValid(userAccount,userPassword);
            if(valid == "no"){
                code = 411;
            }else{
                code = 1;
            }
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }

    }
    //草拟吗
}
