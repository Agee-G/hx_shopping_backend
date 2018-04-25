package com.dao;

import com.Utils.Page;
import com.entity.UserEntity;

import java.util.List;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 25/04/201808:20
 */
public class UserDao extends BaseDaoImpl<UserEntity>{
    @Override
    public UserEntity load(String id) {
        return super.load(id);
    }

    @Override
    public Long obtainCount(String hql, Object conditions) {
        String hqlx = "select count(userId) " + hql;
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
    @Override
    public void add(UserEntity entity) {
        super.add(entity);
    }

}
