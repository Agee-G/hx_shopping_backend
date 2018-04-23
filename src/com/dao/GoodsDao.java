package com.dao;

import com.Utils.Page;
import com.entity.GoodsEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * @author:lily
 * @date:18/4/23 15 22
 * @description
 */
public class GoodsDao extends BaseDaoImpl<GoodsEntity>{
    @Override
    public Long obtainCount(String hql, Object conditions) {
        String hql1 = "select count(goodsId) "+hql;
        return super.obtainCount(hql1, conditions);
    }

    @Override
    public List search(Page page, String hql, Object conditions) {
        return super.search(page, hql, conditions);
    }

    public GoodsEntity selectGoodsdetial(String goodsId){
        String hql ="select new GoodsEntity(s.storeName,g.goodsName,g.goodsDetails,g.goodsPrice,g.goodsKucun,g.goodsSell,g.goodsPicture,g.goodsStyle) from GoodsEntity g and StoreEntity s where g.goodsStoreid = s.storeId and g.goodsId=?";
        Query query = currentSession().createQuery(hql);
        query.setParameter(1,goodsId);
        return (GoodsEntity)query.uniqueResult();
    }
}
