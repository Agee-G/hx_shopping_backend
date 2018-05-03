package com.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author:lily
 * @date:18/4/23 23 11
 * @description
 */
public class Goods implements Serializable{
    private String goodsId;
    private String goodsName;
    private String goodsDetails;
    private Integer goodsPrice;
    private String goodsStoreid;
    private Integer goodsKucun;
    private Integer goodsSell;
    private String goodsPicture;
    private String goodsStyle;
    private String storeName;

    public Goods(){

    }

    //商品详情的构造方法,有"商家名"
    public Goods(String goodsStoreid,String goodsId) {
        this.goodsStoreid = goodsStoreid;
        this.goodsId = goodsId;

    }

    //商品详情的构造方法,有"商家名"
    public Goods(String goodsStoreid,String storeName,String goodsId,String goodsName,String goodsDetails, Integer goodsPrice, Integer goodsKucun, Integer goodsSell, String goodsStyle, String goodsPicture) {
        this.goodsStoreid = goodsStoreid;
        this.goodsId = goodsId;
        this.storeName = storeName;
        this.goodsName = goodsName;
        this.goodsDetails = goodsDetails;
        this.goodsPrice = goodsPrice;
        this.goodsKucun = goodsKucun;
        this.goodsSell = goodsSell;
        this.goodsPicture = goodsPicture;
        this.goodsStyle = goodsStyle;
    }


    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsStoreid() {
        return goodsStoreid;
    }

    public void setGoodsStoreid(String goodsStoreid) {
        this.goodsStoreid = goodsStoreid;
    }

    public Integer getGoodsKucun() {
        return goodsKucun;
    }

    public void setGoodsKucun(Integer goodsKucun) {
        this.goodsKucun = goodsKucun;
    }

    public Integer getGoodsSell() {
        return goodsSell;
    }

    public void setGoodsSell(Integer goodsSell) {
        this.goodsSell = goodsSell;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public String getGoodsStyle() {
        return goodsStyle;
    }

    public void setGoodsStyle(String goodsStyle) {
        this.goodsStyle = goodsStyle;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "{" +
                "goodsId:'" + goodsId + '\'' +
                ", goodsName:'" + goodsName + '\'' +
                ", goodsDetails:'" + goodsDetails + '\'' +
                ", goodsPrice:" + goodsPrice +
                ", goodsStoreid:'" + goodsStoreid + '\'' +
                ", goodsKucun:" + goodsKucun +
                ", goodsSell:" + goodsSell +
                ", goodsPicture:'" + goodsPicture + '\'' +
                ", goodsStyle:'" + goodsStyle + '\'' +
                ", storeName:'" + storeName + '\'' +
                '}';
    }
}
