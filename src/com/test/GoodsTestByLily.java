package com.test;

import com.Utils.Page;
import com.biz.GoodsBiz;
import com.entity.GoodsConditions;
import com.entity.GoodsEntity;

/**
 * @author:lily
 * @date:18/4/23 22 05
 * @description
 */
public class GoodsTestByLily {
    public static void main(String []args){
        GoodsBiz goodsBiz = new GoodsBiz();

        //测试一下查询商品：条件＋分页
//        Page<GoodsEntity> page = new Page<>();
//        page.setPageSize(3);
//        page.setCurrentPage(1);
//        GoodsConditions goodsConditions = new GoodsConditions(null ,null,null,null,100,500,1,null);
//        goodsBiz.selectGoodsByConditions(page,goodsConditions);
//        if(page.getPageList().size() > 0){
//            for (GoodsEntity g:page.getPageList()) {
//               System.out.println(g.toString());
//            }
//        }

        //测试一下查询指定id的商品详情
        System.out.println(goodsBiz.selectGoodsdetial("3").toString());

        //测试一下删除指定id的商品
        //goodsBiz.deleteGoods("6");


    }
}
