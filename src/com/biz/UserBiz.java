package com.biz;

import com.dao.UserDao;
import com.entity.RemarkEntity;
import com.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Map;
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
            if(valid.equals("no")){
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

    public String accountValid(String userAccount){
        String valid = "no";
        Transaction tran = null;
        Session session = userDao.currentSession();
        try{
            tran = session.beginTransaction();
            valid = userDao.accountValid(userAccount);

            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
        return valid;
    }
    //草拟吗

    public void editUserinfo(Map<String,String> userinfo){
        Transaction tran = null;
        Session session = userDao.currentSession();
        try{
            tran = session.beginTransaction();
            String editString = userDao.editUserinfo(userinfo);
            switch (editString){
                case "password edit":
                    code = 4;
                    break;
                case "nickname edit":
                    code = 5;
                    break;
                case "userbankcard edit":
                    code = 6;
                    break;
                case "none":
                    code = 414;
                    break;
                default:
                    code = 415;
                    break;
            }
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
    public UserEntity selectUserwithlogin(String userAccount){
        Transaction tran = null;
        List<UserEntity> list = null;
        UserEntity userEntity = new UserEntity();
        Session session = userDao.currentSession();
        try{
            tran = session.beginTransaction();
            list = userDao.selectUserwithlogin(userAccount);
            userEntity = list.get(0);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
        return userEntity;
    }
    /**
     * @description：查询用户等级
     * @author：heyi
     * @date：2018/5/9 21:10
     * @version：v1.0
     */
    public String searchUserlevel() {
        String userLevel = "";
        Transaction tran = null;
        Session session = userDao.currentSession();
        try {
            tran = session.beginTransaction();
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            UserEntity userEntity = session.get(UserEntity.class, userid);
            int score  = userEntity.getUserTotalscore();
            switch (score/2000){
                case 0:
                    userLevel = "普通用户";
                    break;
                case 1:
                    userLevel = "1级会员";
                    break;
                case 2:
                    userLevel = "2级会员";
                    break;
                case 3:
                    userLevel = "3级会员";
                    break;
                case 4:
                    userLevel = "4级会员";
                    break;
                case 5:
                    userLevel = "5级会员";
                    break;
                case 6:
                    userLevel = "6级会员";
                    break;
                default:
                    userLevel = "至尊会员";
                    break;
            }
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        return userLevel;
    }

}
