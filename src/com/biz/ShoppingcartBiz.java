package com.biz;

import com.dao.ShoppingcartDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/5/9 下午8:10
 */
public class ShoppingcartBiz {
    private int code = 0;
    private ShoppingcartDao shoppingcartDao = new ShoppingcartDao();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ShoppingcartDao getShoppingcartDao() {
        return shoppingcartDao;
    }

    public void setShoppingcartDao(ShoppingcartDao shoppingcartDao) {
        this.shoppingcartDao = shoppingcartDao;
    }

    public int userShoppingcartCount(String userId){
        int count = 0;
        Transaction tran = null;
        Session session = shoppingcartDao.currentSession();
        try{
            tran = session.beginTransaction();
            count = shoppingcartDao.userShoppingcartCount(userId);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
        return count;
    }
}
