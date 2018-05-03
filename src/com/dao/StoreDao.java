package com.dao;

import com.Utils.Page;
import com.entity.StoreEntity;
import com.entity.StoreapplyEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 27/04/201819:18
 */
public class StoreDao extends BaseDaoImpl<StoreEntity>{

    @Override
    public StoreEntity get(String id) {
        return super.get(id);
    }

    @Override
    public StoreEntity load(String id) {
        return super.load(id);
    }

    @Override
    public Long obtainCount(String hql, Object conditions) {
        String hqlx = "select count(storeId) " + hql;
        return super.obtainCount(hqlx, conditions);
    }

    @Override
    public void update(StoreEntity entity) {
        super.update(entity);
    }

    @Override
    public List search(String hql, Object conditions) {
        return super.search(hql, conditions);
    }

    @Override
    public List search(Page page, String hql, Object conditions) {
        return super.search(page, hql, conditions);
    }

    public void updateStoreStatus(StoreEntity storeEntity){
        String hql = "update StoreEntity s set s.storeStatus = :status where s.id = :id";
        Query query = currentSession().createQuery(hql);
        query.setString("status",storeEntity.getStoreStatus());
        query.setString("id",storeEntity.getStoreId());
        query.executeUpdate();
    }

    public void insertNewStore(StoreEntity storeEntity){
        String sql = "insert into store (store_id,store_account,store_password,store_name) values(?,?,?,?)";
        Query query = currentSession().createSQLQuery(sql);
        query.setString(0,storeEntity.getStoreId());
        query.setString(1,storeEntity.getStoreAccount());
        query.setString(2,storeEntity.getStorePassword());
        query.setString(3,storeEntity.getStoreName());
        query.executeUpdate();
    }

    public void updateStore(StoreEntity storeEntity){
        String hql = "update StoreEntity s set s.storeName = :name,s.storePassword = :password,s.storeBalance = :balance,s.storePicture = :picture where s.id = :id";
        Query query = currentSession().createQuery(hql);
        query.setString("name",storeEntity.getStoreName());
        query.setString("password",storeEntity.getStorePassword());
        query.setDouble("balance",storeEntity.getStoreBalance());
        query.setString("picture",storeEntity.getStorePicture());
        query.setString("id",storeEntity.getStoreId());
        query.executeUpdate();

    }

    public void insertNewStoreApply(StoreapplyEntity storeapplyEntity){
        String hql = "insert into storeapply (storeapply_id,storeapply_storeid,storeapply_detail) values (?,?,?);";
        Query query = currentSession().createSQLQuery(hql);
        query.setString(0,storeapplyEntity.getStoreapplyId());
        query.setString(1,storeapplyEntity.getStoreapplyStoreid());
        query.setString(2,storeapplyEntity.getStoreapplyDetail());
        query.executeUpdate();
    }

    public Long findStoreApply(StoreEntity storeEntity){
        String hql = "select count(storeapplyId) from StoreapplyEntity s where s.storeapplyStoreid=:storeId";
        Query query = currentSession().createQuery(hql);
        query.setString("storeId",storeEntity.getStoreId());
        return (Long) query.uniqueResult();
    }
}

