package com.dao;

import com.Utils.Page;
import org.hibernate.Query;
import org.hibernate.Session;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author:lily
 * @date:18/4/22 20 03
 * @description
 */
public class BaseDaoImpl<T> implements BaseDao<T>{
    private Class<T> clazz;

    public BaseDaoImpl() {
        // 使用反射技术得到T的真实类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }
    @Override
    public Session currentSession(){
        return HibernateSessionFactory.getSession();
    }

    @Override
    public void add(T entity) {
        currentSession().save(entity);
    }

    @Override
    public void add(List list) {
        for (Object o:list) {
            currentSession().save(o);
        }
    }

    @Override
    public T get(String id) {
        return currentSession().get(clazz,id);
    }

    @Override
    public T load(String id) {
        return currentSession().load(clazz,id);
    }

    @Override
    public void delete(T entity) {
        currentSession().delete(entity);
    }

    @Override
    public void delete2(String id) {
        T entity = currentSession().get(clazz, id);
        currentSession().delete(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void merge(T entity) {
        currentSession().merge(entity);
    }

    @Override
    public void update(T entity) {
        currentSession().update(entity);
    }
    @Override
    public Long obtainCount(String hql, Object conditions) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql).setProperties(conditions);
        query.setProperties(conditions);
        return (Long) query.uniqueResult();// 返回唯一的结果
    }
    @Override
    public List search(String hql, Object[] conditions) {
        Query query = currentSession().createQuery(hql);
            if (conditions != null && conditions.length > 0) {
                for (int i = 0; i < conditions.length; i++) {
                    query.setParameter(i, conditions[i]);
                }
            }

        return query.list();
    }

    @Override
    public List search(String hql, Object conditions) {
        Query query = currentSession().createQuery(hql).setProperties(conditions);
        return query.list();
    }

    @Override
    public List search(Page page, String hql, Object conditions) {
        Query query = HibernateSessionFactory.getSession().createQuery(hql);
        query.setProperties(conditions);
        query.setFirstResult((page.getCurrentPage()-1)*page.getPageSize());
        query.setMaxResults(page.getPageSize());
        return query.list();
    }

}
