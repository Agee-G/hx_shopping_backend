package com.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:lily
 * @date:18/4/20 22 06
 * @description
 */
public class Order {

    private Timestamp orderTime;
    private String orderNum;
    private String storeId;
    private Integer totalPrice;
    private Integer orderStatus;
    private String address;
    private String addressPhone;
    private String addressUserName;

    private String storeName;

    private List orderGoodList = new ArrayList();

    public Order() {
    }
    //o.createAt,o.orderNumber,o.orderStoreid,o.orderTotalprice,o.orderStatus,o.orderAddress,o.orderAddressphone,o.orderAddressusername)from OrdersEntity o where 1=1 ");
    public Order( String orderNum, String storeId, Integer totalPrice, Integer orderStatus, String address, String addressPhone, String addressUserName) {
        this.orderNum = orderNum;
        this.storeId = storeId;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.address = address;
        this.addressPhone = addressPhone;
        this.addressUserName = addressUserName;
    }
    public Order(Timestamp orderTime, String orderNum, String storeId, Integer totalPrice, Integer orderStatus, String address, String addressPhone, String addressUserName) {
        this.orderTime = orderTime;
        this.orderNum = orderNum;
        this.storeId = storeId;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.address = address;
        this.addressPhone = addressPhone;
        this.addressUserName = addressUserName;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressUserName() {
        return addressUserName;
    }

    public void setAddressUserName(String addressUserName) {
        this.addressUserName = addressUserName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List getOrderGoodList() {
        return orderGoodList;
    }

    public void setOrderGoodList(List orderGoodList) {
        this.orderGoodList = orderGoodList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderTime=" + orderTime +
                ", orderNum='" + orderNum + '\'' +
                ", storeId='" + storeId + '\'' +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                ", address='" + address + '\'' +
                ", addressPhone='" + addressPhone + '\'' +
                ", addressUserName='" + addressUserName + '\'' +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
