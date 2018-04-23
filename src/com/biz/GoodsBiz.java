package com.biz;

import com.Utils.Page;
import com.dao.GoodsDao;
import com.entity.GoodsConditions;
import com.entity.GoodsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.UUID;

/**
 * @author:lily
 * @date:18/4/23 15 20
 * @description
 */
public class GoodsBiz {
    private int code = 0;
    private GoodsDao goodsDao = new GoodsDao();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
    //添加商品
    public void addGoods(GoodsEntity goodsEntity){
        goodsEntity.setGoodsId(UUID.randomUUID().toString());
        Transaction tran = null;
        Session session = goodsDao.currentSession();
        try {
            tran = session.beginTransaction();
            session.save(goodsEntity);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }

    //查询商品 分页＋条件
    public void selectGoodsByConditions(Page<GoodsEntity> page,GoodsConditions goodsConditions){
        StringBuffer hql = new StringBuffer("from GoodsEntity g where 1=1 ");
        if(goodsConditions.getGoodsName() != null){
            goodsConditions.setGoodsName("%"+goodsConditions.getGoodsName()+"%");
            hql.append(" and g.goodsName like :goodsName");
        }
        if(goodsConditions.getGoodsType() != null ){
            hql.append(" and g.goodsType = :goodsType");
        }
        if(goodsConditions.getGoodsStyle() != null){
            hql.append(" and g.goodsStyle = :goodsStyle");
        }
        if(goodsConditions.getGoodsStoreid() != null){
            hql.append(" and g.goodsStoreid = :goodsStoreid");
        }
        if(goodsConditions.getMaxPrice() != null && goodsConditions.getMaxPrice() > 0){
            hql.append(" and g.goodsPrice < :maxPrice");
        }
        if(goodsConditions.getMinPrice() != null){
            hql.append(" and g.goodsPrice > :minPrice");
        }
        if(goodsConditions.getPrice() == 0){
            hql.append(" order by g.goodsPrice asc");
        }else if(goodsConditions.getPrice() == 1){
            hql.append(" order by g.goodsPrice desc");
        }else if(goodsConditions.getSell() == 0){
            hql.append(" order by g.goodsSell asc");
        }else if(goodsConditions.getSell() == 1){
            hql.append(" order by g.goodsSell desc");
        }
        page.setCount(goodsDao.obtainCount(hql.toString(),goodsConditions).intValue());
        page.setPageList(goodsDao.search(hql.toString(),goodsConditions));
    }

    //查询商品详情
    public GoodsEntity selectGoodsdetial(String goodsId){
        GoodsEntity goodsEntity = null;
        Transaction tran = null;
        Session session = goodsDao.currentSession();
        try {
            tran = session.beginTransaction();
            goodsEntity = goodsDao.selectGoodsdetial(goodsId);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
        return goodsEntity;
    }

    //删除商品
    public void deleteGoods(String goodsId){
        GoodsEntity goodsEntity = null;
        Transaction tran = null;
        Session session = goodsDao.currentSession();
        try {
            tran = session.beginTransaction();
            goodsEntity = session.get(GoodsEntity.class,goodsId);
            if (goodsEntity == null){
                setCode(201);
            }else{
                session.delete(goodsEntity);
            }
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
    public void editGoods(GoodsEntity goodsEntity){
        Transaction tran = null;
        Session session = goodsDao.currentSession();
        try {
            tran = session.beginTransaction();
            session.merge(goodsEntity);
            tran.commit();
        }catch (HibernateException e){
            if(tran != null){
                tran.rollback();
            }
            e.printStackTrace();
        }
    }


}
