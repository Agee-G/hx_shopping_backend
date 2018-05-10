package com.dao;
import com.Utils.Page;
import com.entity.*;
import org.hibernate.Query;
import java.util.List;
/**
 * @author:20155808李连芸
 * @date:18/4/20 09 28
 * @description
 * orderStatus - 0:待付款 1:待发货 2:待收货 3:已收货 4:已评价 5:等待用户退款同意中 6:等待商家退款同意中 7：已退款(退款货物到达) 8:已删除
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
    //根据订单list，修改商品库存，修改商品销量。1:支付完成，商品库存减少，商品销量增加。2:退货成功，商品库存增加，商品销量减少。
    //返回1:改变成功，返回0:改变失败，传来的状态码错误。
    public int  updateGoodsByOrder(List<OrdersEntity> orderList, int state){
        for(OrdersEntity ordersEntity : orderList){
            String hql="select o.goodsid,o.ordergoodsNum from OrdergoodsEntity o where o.ordergoodsOrdernum = "+ordersEntity.getOrderNumber();
            List<Object[]> objectList = currentSession().createQuery(hql).list();
            if(state == 1) {
                for (Object[] obj : objectList) {
                    GoodsEntity goodsEntity = currentSession().get(GoodsEntity.class, obj[1].toString());
                    goodsEntity.setGoodsSell(goodsEntity.getGoodsSell() - (Integer) obj[2]);
                    goodsEntity.setGoodsKucun(goodsEntity.getGoodsKucun() + (Integer) obj[2]);
                }
            }
            else if(state == 2) {
                for (Object[] obj : objectList) {
                    GoodsEntity goodsEntity = currentSession().get(GoodsEntity.class, obj[1].toString());
                    goodsEntity.setGoodsSell(goodsEntity.getGoodsSell() + (Integer) obj[2]);
                    goodsEntity.setGoodsKucun(goodsEntity.getGoodsKucun() - (Integer) obj[2]);
                }
            }
        }
        return 0;
    }
}
