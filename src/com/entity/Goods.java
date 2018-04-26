package com.entity;

/**
 * @author:lily
 * @date:18/4/23 23 11
 * @description
 */
public class Goods {
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

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDetails='" + goodsDetails + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsStoreid='" + goodsStoreid + '\'' +
                ", goodsKucun=" + goodsKucun +
                ", goodsSell=" + goodsSell +
                ", goodsPicture='" + goodsPicture + '\'' +
                ", goodsStyle='" + goodsStyle + '\'' +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
