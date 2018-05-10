package com.biz;

import com.dao.AddressDao;
import com.entity.AddressEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/5/10 上午8:34
 */
public class AddressBiz {
    private int code = 0;
    private AddressDao addressDao = new AddressDao();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
    public void addAddress(AddressEntity addressEntity){
        Transaction tran = null;
        Session session = addressDao.currentSession();
        try{
            tran = session.beginTransaction();
            addressDao.addAddress(addressEntity);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
    public int defalutAddressCount(String userId){
        int count = 0;
        Transaction tran = null;
        Session session = addressDao.currentSession();
        try{
            tran = session.beginTransaction();
            count = addressDao.defalutAddressCount(userId);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
        return count;
    }
    public List<AddressEntity> selectAddress(String userId){
        Transaction tran = null;
        List<AddressEntity> list = null;
        Session session = addressDao.currentSession();
        try{
            tran = session.beginTransaction();
            list = addressDao.selectAddress(userId);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }
    public void editAddressinfo(AddressEntity addressEntity){
        Transaction tran = null;
        Session session = addressDao.currentSession();
        try{
            tran = session.beginTransaction();
            addressDao.editAddressinfo(addressEntity);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
    public void deleteAddress(String addressId){
        Transaction tran = null;
        Session session = addressDao.currentSession();
        try{
            tran = session.beginTransaction();
            addressDao.deleteAddress(addressId);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
}
