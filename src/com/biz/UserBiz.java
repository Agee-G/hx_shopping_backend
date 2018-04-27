package com.biz;

import com.dao.UserDao;
import com.entity.RemarkEntity;
import com.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        try {
            //开启事务
            tran = session.beginTransaction();
            userEntity.setUserId(UUID.randomUUID().toString());
            String sql = "insert into user (user_id,user_account,user_password,user_nickname)  values(?,?,?,?)";
            Query query= session.createSQLQuery(sql);
            query.setString(1, userEntity.getUserId());
            query.setString(2, userEntity.getUserAccount());
            query.setString(3, userEntity.getUserPassword());
            query.setString(4, userEntity.getUserNickname());
            query.executeUpdate();
            //提交事务
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
    //草拟吗
}
