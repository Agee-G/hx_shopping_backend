package com.dao;

import com.entity.AddressEntity;
import org.hibernate.Query;

import java.util.List;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/5/10 上午8:24
 */
public class AddressDao extends BaseDaoImpl<AddressEntity>{
    public void addAddress(AddressEntity addressEntity){
        String sql = "insert into address (address_id, address, address_username, address_phone, address_user,address_level)  values(?,?,?,?,?,?)";
        Query query = currentSession().createSQLQuery(sql);
        query.setString(0,addressEntity.getAddressId());
        query.setString(1,addressEntity.getAddress());
        query.setString(2,addressEntity.getAddressUsername());
        query.setString(3,addressEntity.getAddressPhone());
        query.setString(4,addressEntity.getAddressUser());
        query.setString(5,addressEntity.getAddressLevel());
        query.executeUpdate();
    }

    public int defalutAddressCount(String userId){
        String hql = "select count(*) from AddressEntity where addressUser = :userId AND addressLevel = '1'";
        Query query = currentSession().createQuery(hql);
        query.setString("userId",userId);
        return ((Long)query.uniqueResult()).intValue();
    }
    public List<AddressEntity> selectAddress(String userId){
        List<AddressEntity> list = null;
        String hql = "from AddressEntity where addressUser = :userId";
        Query query = currentSession().createQuery(hql);
        query.setString("userId",userId);
        list = query.list();
        return list;
    }
    public void editAddressinfo(AddressEntity addressEntity){

    }
}
