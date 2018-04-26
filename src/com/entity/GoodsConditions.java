package com.entity;

import java.sql.Timestamp;

/**
 * @author:lily
 * @date:18/4/23 17 25
 * @description
 */
public class GoodsConditions {
    /*
    根据 商品名称、商品价格、商品类别、商家id、查询商品
    按销量升序降序排列、按价格升序降序排列
     */
    private String goodsName;
    private Integer goodsType;
    private String goodsStyle;
    private String goodsStoreid;

    private Integer minPrice;
    private Integer maxPrice;

    private Integer price;//1:价格降序 0:价格升序
    private Integer sell;//1:销量降序 0:销量升序

    public GoodsConditions() {}

    public GoodsConditions(String goodsName, Integer goodsType, String goodsStyle, String goodsStoreid, Integer minPrice, Integer maxPrice, Integer price, Integer sell) {
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.goodsStyle = goodsStyle;
        this.goodsStoreid = goodsStoreid;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.price = price;
        this.sell = sell;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsStyle() {
        return goodsStyle;
    }

    public void setGoodsStyle(String goodsStyle) {
        this.goodsStyle = goodsStyle;
    }

    public String getGoodsStoreid() {
        return goodsStoreid;
    }

    public void setGoodsStoreid(String goodsStoreid) {
        this.goodsStoreid = goodsStoreid;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }
}
