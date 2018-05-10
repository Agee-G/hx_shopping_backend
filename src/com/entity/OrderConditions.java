package com.entity;

/**
 * @author:李连芸
 * @date:18/4/21 11 17
 * @description
 */
public class OrderConditions {

    private String  userid;
    private String  storeid;
    private String  orderNum;
    private String  orderGoodname;
    private String  orderStatus;
    private String  userScore;

    public OrderConditions() {

    }

    public OrderConditions(String  userScore,String userid, String storeid, String orderNum, String orderGoodname, String orderStatus) {
        this.userScore = userScore;
        this.userid = userid;
        this.storeid = storeid;
        this.orderNum = orderNum;
        this.orderGoodname = orderGoodname;
        this.orderStatus = orderStatus;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderGoodname() {
        return orderGoodname;
    }

    public void setOrderGoodname(String orderGoodname) {
        this.orderGoodname = orderGoodname;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
