package com.test;

import com.Utils.Page;
import com.biz.OrderBiz;
import com.dao.OrderDao;
import com.entity.OrderConditions;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * @author:lily
 * @date:18/4/20 19 49
 * @description
 */
public class Test {
    public static void main(String args[]){
        OrderBiz orderBiz = new OrderBiz();
        //测试一下查询订单
        Page page = new Page();
        page.PAGESIZE = 1;
        page.setCurrentPage(2);
        OrderConditions orderConditions = new OrderConditions("1","1",null,null,null);
        orderBiz.searchOrders(page,orderConditions);


        //测试一下直接购买生成订单
//        orderBiz.addOrder("2","1",3,"red",23,"1");

        //hehe
        //测试一下从购物车生成订单
//        HashMap<String,String[]> orderData = new HashMap<>();
//        String[] strings = {"1","2"};
//        orderData.put("1",strings);
//        orderBiz.addOrders(orderData,"1");


        //测试一下改变订单状态
//        orderBiz.updateOrder("3",4);
        //测试一下删除订单
//        orderBiz.deleteOrder("3");

        //随便测试一下
//        orderBiz.test2();


        }
}
