package com.dao;

import com.entity.RemarkEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/22 下午8:32
 */
public class RemarkDao extends BaseDaoImpl<RemarkEntity>{
    @Override
    public void add(RemarkEntity entity) {
        super.add(entity);
    }

    public List<RemarkEntity> selectRemarkByLevel(String remarkGoodsid, Integer remarkLevel){
        List<RemarkEntity> list = null;
        //数据库操作
        String hql = "from RemarkEntity where remarkStatus = '1' and remarkLevel = :remarkLevel and remarkGoodsid = :remarkGoodsid";
        Query query = currentSession().createQuery(hql);
        query.setInteger("remarkLevel",remarkLevel);
        query.setString("remarkGoodsid",remarkGoodsid);
        list = query.list();
        return list;
    }

    public List<RemarkEntity> selectRemarkByGoodsId(String remarkGoodsid){
        List<RemarkEntity> list = null;
        String hql = "from RemarkEntity where remarkStatus = '1' and remarkGoodsid = :remarkGoodsid";
        Query query = currentSession().createQuery(hql);
        query.setString("remarkGoodsid",remarkGoodsid);
        list = query.list();
        return list;
    }

}
