package com.dao;

import com.Utils.Page;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * @author:李连芸
 * @date:18/4/22 20 06
 * @description
 */
public interface BaseDao<T> {
    public Session currentSession();
    // 添加数据
    public void add(T entity);
    public void add(List list);
    // get加载数据：记录不存在返回null
    public T get(String id);
    // load加载数据:要求数据必须存在，否则抛出ObjectNotFoundException
    public T load(String id);
    // 删除数据
    public void delete(T entity);
    public void delete2(String id);
    // 更新数据
    public void saveOrUpdate(T entity);
    public void merge(T entity);
    public void update(T entity);
    // 使用uniqueResult获取唯一结果，计算查询条件下的记录数
    public Long obtainCount(String hql, Object conditions);
    // 用hql和object[]查询
    public List search(String hql,Object[] conditions);
    // 用hql和conditions查询
    public List search(String hql,Object conditions);
    // 用hql和conditions查询+分页
    public List search(Page page,String hql, Object conditions);
}
