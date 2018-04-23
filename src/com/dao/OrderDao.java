package com.dao;
import com.Utils.Page;
import com.entity.*;
import org.hibernate.Query;
import java.util.List;
/**
 * @author:20155808李连芸
 * @date:18/4/20 09 28
 * @description
 * orderStatus - 0:待付款 1:待发货 2:待收货 3:已收获 4:以评价 5:仅退款 6:退货退款
 */
public class OrderDao extends BaseDaoImpl<OrdersEntity>{
    @Override
    public Long obtainCount(String hql, Object conditions) {
        String hql1 = "select count(orderId)  " + hql;
        return super.obtainCount(hql1,conditions);
    }
    @Override
    public List search(Page page, String hql, Object conditions) {
        String hql1= "select new com.entity.Order(o.orderNumber,o.orderStoreid,o.orderTotalprice,o.orderStatus,o.orderAddress,o.orderAddressphone,o.orderAddressusername)"+hql;
        return super.search(page, hql1, conditions);
    }
    //删除订单
    public void deleteOrderGoods(String  orderNumber){
        String hql = "delete from OrdergoodsEntity g where g.ordergoodsOrdernum = ?";
        Query  query = currentSession().createQuery(hql);
        query.setString(0,orderNumber);
    }
    //查询订单商品
    public List<OrdergoodsEntity> searchOrderGoods(String orderNum){
        String hql="from OrdergoodsEntity o where o.ordergoodsOrdernum = :orderNum";
        Query query = currentSession().createQuery(hql);
        query.setParameter("orderNum",orderNum);
        return query.list();
    }
}
