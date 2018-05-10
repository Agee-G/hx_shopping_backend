package com.dao;

import com.entity.StoreapplyEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 09/05/201815:21
 */
public class StoreApplyDao extends BaseDaoImpl<StoreapplyEntity> {
    public List<StoreapplyEntity> findAllApply(){
        String hql = "from StoreapplyEntity";
        Query query = currentSession().createQuery(hql);
        return query.list();
    }
    public List<StoreapplyEntity> findApplyByStoreId(String storeId){
        String hql = "from StoreapplyEntity a where a.storeapplyStoreid = :storeId";
        Query query = currentSession().createQuery(hql);
        query.setParameter("storeId",storeId);
        return query.list();
    }
    public void updateApplyStatus(StoreapplyEntity storeapplyEntity){
        String hql = "update StoreapplyEntity a set a.storeapplyStatus = :status where a.storeapplyId= :id";
        Query query = currentSession().createQuery(hql);
        query.setString("status",storeapplyEntity.getStoreapplyStatus());
        query.setString("id",storeapplyEntity.getStoreapplyId());
        query.executeUpdate();
    }

}
