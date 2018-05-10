package com.dao;

import com.entity.ShoppingcartEntity;
import org.hibernate.Query;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/5/9 下午7:46
 */
public class ShoppingcartDao extends BaseDaoImpl<ShoppingcartEntity>{

    public int userShoppingcartCount(String userId){
        String hql = "select count(*) from ShoppingcartEntity where shoppingcartUser = :userId";
        Query query = currentSession().createQuery(hql);
        query.setString("userId",userId);
        return ((Long)query.uniqueResult()).intValue();
    }
}
