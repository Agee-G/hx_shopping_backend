package com.biz;

import com.Utils.Page;
import com.dao.HibernateSessionFactory;
import com.dao.OrderDao;
import com.entity.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

/**
 * @author:lily
 * @date:18/4/22 19 37
 * @description
 */
public class OrderBiz {
    private OrderDao orderDao = new OrderDao();
    private int code = 0;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    //直接购买
    public void addOrder(String storeid,String goodsId,Integer goodsNum,String goodType,Integer orderTotalprice,String orderAddressId){
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            String orderNumber = "订单编号aaa";
            GoodsEntity goodsEntity = session.get(GoodsEntity.class,goodsId);
            if(goodsEntity == null){
                code = 201;//商品id不存在
            }
            OrdergoodsEntity ordergoodsEntity = new OrdergoodsEntity();
            ordergoodsEntity.setOrdergoodsId(UUID.randomUUID().toString());
            ordergoodsEntity.setOrdergoodsName(goodsEntity.getGoodsName());
            ordergoodsEntity.setOrdergoodsPicture(goodsEntity.getGoodsPicture());
            ordergoodsEntity.setOrdergoodsPrice(goodsEntity.getGoodsPrice());
            ordergoodsEntity.setOrdergoodsNum(goodsNum);
            ordergoodsEntity.setOrdergoodsMerchant(goodsEntity.getGoodsStoreid());
            ordergoodsEntity.setOrdergoodsOrdernum(orderNumber);
            ordergoodsEntity.setOrdergoodsStyle(goodType);
            session.merge(ordergoodsEntity);

            AddressEntity addressEntity = session.get(AddressEntity.class,orderAddressId);
            if(addressEntity == null){
                code = 202;//地址id不存在
            }
            OrdersEntity ordersEntity= new OrdersEntity();
            ordersEntity.setOrderId(UUID.randomUUID().toString());
            ordersEntity.setOrderUserid(userid);
            ordersEntity.setOrderStoreid(storeid);
            ordersEntity.setOrderNumber(orderNumber);
            ordersEntity.setOrderAddress(addressEntity.getAddress());
            ordersEntity.setOrderAddressphone(addressEntity.getAddressPhone());
            ordersEntity.setOrderAddressusername(addressEntity.getAddressUsername());
            ordersEntity.setOrderDelay(0);
            ordersEntity.setOrderStatus(0);
            ordersEntity.setOrderTotalprice(orderTotalprice);
            session.merge(ordersEntity);

            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        setCode(code);
    }
    //购物车购买
    public void addOrders(HashMap<String,String[]> orderData, String orderAddressId) {
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            //待解决：登录的时候把用户id存入session中
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            if (orderData == null){
                code =  211;//没有传来购物车结算订单和商品信息
            }
            for (String store_id:orderData.keySet()) {
                //待解决：订单编号
                String orderNumber = "订单编号9999";
                String[] ids = orderData.get(store_id);
                if (ids.length == 0){
                    code =  212;//没有传来用户所购买的商家订单的购物车id
                }
                int totalPrice = 0;
                for (String shoppingcart_id:ids) {
                    ShoppingcartEntity shoppingcartEntity = session.get(ShoppingcartEntity.class,shoppingcart_id);
                    if (shoppingcartEntity == null){
                        code =  203;//购物车id不存在；
                    }
                    GoodsEntity goodsEntity = session.get(GoodsEntity.class,shoppingcartEntity.getShoppingcartGoodsid());
                    if (goodsEntity == null){
                        code =  204;//购物车对应的商品ID不存在；
                    }
                    OrdergoodsEntity ordergoodsEntity = new OrdergoodsEntity();
                    ordergoodsEntity.setOrdergoodsId(UUID.randomUUID().toString());
                    ordergoodsEntity.setOrdergoodsName(goodsEntity.getGoodsName());
                    ordergoodsEntity.setOrdergoodsPicture(goodsEntity.getGoodsPicture());
                    ordergoodsEntity.setOrdergoodsPrice(goodsEntity.getGoodsPrice());
                    ordergoodsEntity.setOrdergoodsNum(shoppingcartEntity.getShoppingcartGoodsnum());
                    ordergoodsEntity.setOrdergoodsMerchant(goodsEntity.getGoodsStoreid());
                    ordergoodsEntity.setOrdergoodsOrdernum(orderNumber);
                    ordergoodsEntity.setOrdergoodsStyle(shoppingcartEntity.getShoppingcartGoodsStyle());
                    session.merge(ordergoodsEntity);//以防session中有相同id的数据，save会报错
                    totalPrice += goodsEntity.getGoodsPrice()*shoppingcartEntity.getShoppingcartGoodsnum();
                }
                AddressEntity addressEntity = session.get(AddressEntity.class,orderAddressId);
                if(addressEntity == null){
                    code =  202;//地址id不存在
                }
                OrdersEntity ordersEntity= new OrdersEntity();
                ordersEntity.setOrderId(UUID.randomUUID().toString());
                ordersEntity.setOrderUserid(userid);
                ordersEntity.setOrderStoreid(store_id);
                ordersEntity.setOrderNumber(orderNumber);
                ordersEntity.setOrderAddress(addressEntity.getAddress());
                ordersEntity.setOrderAddressphone(addressEntity.getAddressPhone());
                ordersEntity.setOrderAddressusername(addressEntity.getAddressUsername());
                ordersEntity.setOrderDelay(0);
                ordersEntity.setOrderStatus(0);
                ordersEntity.setOrderTotalprice(totalPrice);
                session.merge(ordersEntity);
            }
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        setCode(code);
    }
    //查询订单
    public void searchOrders(Page<Order> orderPage,OrderConditions orderConditions){
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        List<Order> orderList = new ArrayList<>();
        try {
            tran = session.beginTransaction();
            //查询符合条件的订单
            StringBuffer hql=new StringBuffer("select new com.entity.Order(o.orderNumber,o.orderStoreid,o.orderTotalprice,o.orderStatus,o.orderAddress,o.orderAddressphone,o.orderAddressusername)from OrdersEntity o where 1=1 ");
            StringBuffer hql2=new StringBuffer("select count(orderId) from OrdersEntity o where 1=1 ");
System.out.println("------------a");
            //待解决：查不到createAt
            //StringBuffer hql=new StringBuffer("select new com.entity.Order( o.createAt,o.orderNumber,o.orderStoreid,o.orderTotalprice,o.orderStatus,o.orderAddress,o.orderAddressphone,o.orderAddressusername)from OrdersEntity o where 1=1 ");
            if(orderConditions.getUserid() != null && orderConditions.getUserid().length()>0){
                hql.append(" and o.orderUserid = :userid ");
                hql2.append(" and o.orderUserid = :userid ");
            }
            if(orderConditions.getStoreid() != null && orderConditions.getStoreid().length()>0){
                hql.append(" and o.orderStoreid = :storeid ");
                hql2.append(" and o.orderStoreid = :storeid ");
            }
            if(orderConditions.getOrderStatus() != null){
                hql.append(" and o.orderStatus = :orderStatus ");
                hql2.append(" and o.orderStatus = :orderStatus ");
            }
            //待解决：根据商品的名字查找
//            if(orderConditions.getOrderGoodname() != null && orderConditions.getOrderGoodname().length()>0){
//                orderConditions.setOrderGoodname("%"+orderConditions.getOrderGoodname()+"%");
//                hql.append(" and o.title like :title ");
//            }
            if(orderConditions.getOrderNum() != null && orderConditions.getOrderNum().length()>0){
                orderConditions.setOrderNum("%"+orderConditions.getOrderNum()+"%");
                hql.append(" and o.orderNumber like :orderNum ");
                hql2.append(" and o.orderNumber like :orderNum ");
            }
            System.out.println("------------b");
            orderPage.setCount(orderDao.obtainCount(hql2.toString(), orderConditions).intValue());
            System.out.println("------------c");
            List<Order> orders = orderDao.search(orderPage,hql.toString(),orderConditions);
            System.out.println("------------d");
            if(orders.size() == 0){
                code = 205;//没有该查询条件下的订单
            }else {
                for (Order  order :orders){
                    //Order order = new Order();
                    String oid = order.getStoreId();
                    //查询订单商家的名字
                    StoreEntity storeEntity = session.get(StoreEntity.class,oid);
                    if(storeEntity == null){
                        code = 206;//订单没有对应的商店
                    }
                    //查询订单商品
                    String hql3="from OrdergoodsEntity o where o.ordergoodsOrdernum = :orderNum";
                    Query query3 = session.createQuery(hql3);
                    query3.setParameter("orderNum",order.getOrderNum());
                    List<OrdergoodsEntity> ordergoodsEntityList = query3.list();
                    if(ordergoodsEntityList.size() == 0){
                        code = 201;//该订单没有商品
                    }

                    //添加到order数据实体中
                    order.setStoreName(storeEntity.getStoreName());
                    order.getOrderGoodList().addAll(ordergoodsEntityList);
                    orderList.add(order);
                }

                for (int i = 0; i < orderList.size(); i++) {
                    System.out.println("orderMsg:___"+orderList.get(i).toString());
                    for (int j = 0; j <orderList.get(i).getOrderGoodList().size() ; j++) {
                        System.out.println("orderGoodMsg:____"+orderList.get(i).getOrderGoodList().get(j).toString());

                    }
                }
            }

            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }

        setCode(code);
        orderPage.setPageList(orderList);
    }

    //更新订单状态
    public void updateOrder(String orderId,Integer orderStatus){
        OrdersEntity ordersEntity = (OrdersEntity)orderDao.get(orderId);
        if(ordersEntity == null){
            code = 207;//订单id不存在
        }else{
            ordersEntity.setOrderStatus(orderStatus);
            orderDao.merge(ordersEntity);
        }
        setCode(code);
    }

    //删除订单
    public void deleteOrder(String orderId){

        Transaction tran = null;
        Query query = null;
        Session session = HibernateSessionFactory.getSession();
        try {
            tran = session.beginTransaction();
            OrdersEntity ordersEntity = session.get(OrdersEntity.class,orderId);
            if (ordersEntity == null){
                code = 207;//订单id不存在
            }else {
                String hql = "delete from OrdergoodsEntity g where g.ordergoodsOrdernum = ?";
                query = session.createQuery(hql);
                query.setString(0,ordersEntity.getOrderNumber());
                Iterator iterator = query.list().iterator();
                while (iterator.hasNext()){
                    session.delete(iterator.next());
                }
                session.delete(ordersEntity);
            }

            tran.commit();
        } catch (Exception e) {
            if (tran !=  null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        setCode(code);
    }



    //随便测试一下
    public void test2(){
        Transaction tran = null;
        Session session = HibernateSessionFactory.getSession();
        Query query = null;
        try {
            tran = session.beginTransaction();
            //StringBuffer hql=new StringBuffer("select new com.entity.Order(o.orderNumber,o.orderStoreid,o.orderTotalprice,o.orderStatus,o.orderAddress,o.orderAddressphone,o.orderAddressusername)from OrdersEntity o where 1=1 ");
            //query = session.createQuery(hql.toString());


            query = session.createQuery("from OrdersEntity");
            Iterator iterable = query.list().iterator();
            if(iterable.hasNext()){
                System.out.println("111----"+iterable.next().toString());
            }
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }

    }

}
