package com.dao;

import com.Utils.Page;
import com.entity.Goods;
import com.entity.GoodsEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * @author:李连芸
 * @date:18/4/23 15 22
 * @description
 */
public class GoodsDao extends BaseDaoImpl<GoodsEntity>{
    @Override
    public Long obtainCount(String hql, Object conditions) {
        String hql1 = "select count(g.goodsId) "+hql;
        return super.obtainCount(hql1, conditions);
    }

    @Override
    public List search(Page page, String hql, Object conditions) {
        String hql2 = "select new GoodsEntity(g.goodsId,g.goodsName,g.goodsType,g.goodsPrice,g.goodsKucun,g.goodsSell,g.goodsPicture)  "+hql;
        return super.search(page, hql2, conditions);
    }

    public Goods selectGoodsdetial(String goodsId){
        String hql ="select new com.entity.Goods(g.goodsStoreid,g.goodsName,g.goodsId,s.storeName,g.goodsDetails,g.goodsPrice,g.goodsKucun,g.goodsSell,g.goodsStyle,g.goodsPicture) from GoodsEntity g , StoreEntity s  where g.goodsStoreid = s.storeId and g.goodsId=?";
        Query query = currentSession().createQuery(hql);
        query.setParameter(0,goodsId);
        return (Goods)query.uniqueResult();
    }
}
