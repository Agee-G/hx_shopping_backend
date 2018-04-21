/**
 * @descrpition: 数据访问层
 * @author: 20155808李连芸
 * @date 2018年4月7日 下午5:48:07
 */
package com.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @className: BaseDao.java
 * @descrpition: 数据访问层的基类
 * @author: 20155808李连芸
 * @date 2018年4月7日 下午5:48:07
 */
public class BaseDao<T> {
    private Class<T> clazz;

    public BaseDao() {
        // 使用反射技术得到T的真实类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    // 添加数据
    protected void add(T entity) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            session.save(entity);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
    // 添加数据
    protected int add(List list) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            for (int i = 0; i <list.size() ; i++) {
                session.save(list.get(i));
            }
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    // get加载数据：记录不存在返回null
    protected Object get(Class cla,Serializable id) {
        Object entity = null;
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            entity = session.get(cla, id);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        return entity;
    }
    // load加载数据:要求数据必须存在，否则抛出ObjectNotFoundException
    protected T load(Serializable id) {
        T entity = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            entity = (T) session.load(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    // 删除数据
    protected void delete(T entity) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            session.delete(entity);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
    }

    // 删除数据2
    protected void delete2(Serializable id) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            T entity = load(id);
            session.delete(entity);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
    }

    // 更新数据
    protected void saveOrUpdate(T entity) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            session.saveOrUpdate(entity);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
    }

    // 更新数据
    protected void merge(T entity) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            session.merge(entity);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
    }

    // 更新数据
    protected void update(T entity) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            session.update(entity);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
    // 使用uniqueResult获取唯一结果，计算查询条件下的记录数
    protected Long obtainCount(String hql, Object conditions) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        Query query = null;
        try {
            tran = session.beginTransaction();
            query = session.createQuery(hql).setProperties(conditions);
            query.setProperties(conditions);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }

        return (Long) query.uniqueResult();// 返回唯一的结果
    }
    // 用hql查询
//    protected List<T> search(String hql) {
//        Transaction tran = null;
//        Session session = HibernateSessionFactory.getSession();
//        Query query = null;
//        try {
//            tran = session.beginTransaction();
//            query = session.createQuery(hql);
//            tran.commit();
//        } catch (Exception e) {
//            if (tran != null) {
//                tran.rollback();
//            }
//            e.printStackTrace();
//        }
//        return query.list();
//    }
    // 用hql和object[]查询
    protected List<T> search(String hql,Object[] conditions) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        Query query = null;
        try {
            tran = session.beginTransaction();
            query = session.createQuery(hql);
            if (conditions != null && conditions.length > 0) {
                for (int i = 0; i < conditions.length; i++) {
                    query.setParameter(i, conditions[i]);
                }
            }
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        return query.list();
    }
    // 用hql和conditions查询
    protected List<T> search(String hql,Object conditions) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        Query query = null;
        try {
            tran = session.beginTransaction();
            query = session.createQuery(hql).setProperties(conditions);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        return query.list();
    }

    // 用hql和conditions查询+分页
    protected List<T> search(int currentIndex, int pageSize,String hql,Object conditions) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        Query query = null;
        try {
            tran = session.beginTransaction();
            query = session.createQuery(hql).setProperties(conditions);
            query.setFirstResult((currentIndex-1)*pageSize);
            query.setMaxResults(pageSize);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        return query.list();
    }

}
