package com.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author:lily
 * @date:18/4/22 20 06
 * @description
 */
public interface BaseDao<T> {

    // 添加数据
    public void add(T entity);
    public int add(List list);
    // get加载数据：记录不存在返回null
    public Object get(Class cla,Serializable id);
    // load加载数据:要求数据必须存在，否则抛出ObjectNotFoundException
    public T load(Serializable id);
    // 删除数据
    public void delete(T entity);
    public void delete2(Serializable id);
    // 更新数据
    public void saveOrUpdate(T entity);
    public void merge(T entity);
    public void update(T entity);
    // 使用uniqueResult获取唯一结果，计算查询条件下的记录数
    public Long obtainCount(String hql, Object conditions);
    // 用hql和object[]查询
    public List<T> search(String hql,Object[] conditions);
    // 用hql和conditions查询
    public List<T> search(String hql,Object conditions);
    // 用hql和conditions查询+分页
    public List<T> search(int currentIndex, int pageSize,String hql,Object conditions);
}
