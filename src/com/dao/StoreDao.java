package com.dao;

import com.Utils.Page;
import com.entity.StoreEntity;

import java.util.List;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 27/04/201819:18
 */
public class StoreDao extends BaseDaoImpl<StoreEntity>{
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
    public List search(String hql, Object conditions) {
        return super.search(hql, conditions);
    }

    @Override
    public List search(Page page, String hql, Object conditions) {
        return super.search(page, hql, conditions);
    }
}
