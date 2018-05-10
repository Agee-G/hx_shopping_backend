package com.biz;

import com.dao.HibernateSessionFactory;
import com.dao.RemarkDao;
import com.entity.RemarkEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/22 下午8:33
 */
public class RemarkBiz {
    private int code = 0;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private RemarkDao remarkDao = new RemarkDao();

    public RemarkDao getRemarkDao() {
        return remarkDao;
    }

    public void setRemarkDao(RemarkDao remarkDao) {
        this.remarkDao = remarkDao;
    }

    public void addRemark(RemarkEntity remarkEntity){
        //事务初始化
        Transaction tran = null;
        Session session = remarkDao.currentSession();
        try {
            //开启事务
            tran = session.beginTransaction();
            remarkEntity.setRemarkId(UUID.randomUUID().toString());
            remarkDao.add(remarkEntity);
            //提交事务
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<RemarkEntity> selectRemarkByLevel(String remarkGoodsid,Integer remarkLevel){
        List<RemarkEntity> list = null;
        Transaction tran = null;
        Session session = remarkDao.currentSession();
        try{
            tran = session.beginTransaction();
            list = remarkDao.selectRemarkByLevel(remarkGoodsid,remarkLevel);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }
    public List<RemarkEntity>selectRemarkByGoodsId(String remarkGoodsid){
        List<RemarkEntity> list = null;
        Transaction tran = null;
        Session session = remarkDao.currentSession();
        try{
            tran = session.beginTransaction();
            list = remarkDao.selectRemarkByGoodsId(remarkGoodsid);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public void deleteRemark(String remarkId){
        Transaction tran = null;
        Session session = remarkDao.currentSession();
        try {
            //开启事务
            tran = session.beginTransaction();

            remarkDao.delete2(remarkId);
            //提交事务
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
}
