package com.test;

import com.dao.OrderDao;
import com.entity.OrderConditions;

import java.util.HashMap;

/**
 * @author:lily
 * @date:18/4/20 19 49
 * @description
 */
public class Test {
    public static void main(String args[]){
        OrderDao orderDao = new OrderDao();
        //测试一下直接购买生成订单
//        int res = orderDao.addOrder("2",4,"red",23,"1");

        //测试一下从购物车生成订单
//        HashMap<String,String[]> orderData = new HashMap<>();
//        String[] strings = {"1","2"};
//        orderData.put("1",strings);
//        int res = orderDao.addOrders(orderData,"1");

        //测试一下查询订单
//        OrderConditions orderConditions = new OrderConditions("1","1",null,null,null);
//        int res = orderDao.searchOrders(orderConditions);

        //测试一下改变订单状态
//        orderDao.updateOrder("3",4);
        //测试一下删除订单
//        orderDao.deleteOrder("3");

        //随便测试一下
//        orderDao.test();
//        orderDao.test2();

        //System.out.println("res-----"+res);

        }
}
