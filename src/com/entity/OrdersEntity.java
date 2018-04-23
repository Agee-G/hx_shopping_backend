package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author:lily
 * @date:18/4/20 22 04
 * @description
 */
@Entity
@Table(name = "orders", schema = "hxtaobaocom")
public class OrdersEntity implements Serializable{
    private String orderId;
    private String orderUserid;
    private String orderStoreid;
    private Integer orderTotalprice;
    private String orderNumber;
    private Timestamp orderLasttime;
    private Integer orderDelay;
    private Timestamp createAt;
    private Timestamp updateAt;
    private String orderAddress;
    private String orderAddressphone;
    private String orderAddressusername;
    private Integer orderStatus;

    @Id
    @Column(name = "order_id", nullable = false, length = 128)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_userid", nullable = true, length = 128)
    public String getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(String orderUserid) {
        this.orderUserid = orderUserid;
    }

    @Basic
    @Column(name = "order_storeid", nullable = true, length = 128)
    public String getOrderStoreid() {
        return orderStoreid;
    }

    public void setOrderStoreid(String orderStoreid) {
        this.orderStoreid = orderStoreid;
    }

    @Basic
    @Column(name = "order_totalprice", nullable = true)
    public Integer getOrderTotalprice() {
        return orderTotalprice;
    }

    public void setOrderTotalprice(Integer orderTotalprice) {
        this.orderTotalprice = orderTotalprice;
    }

    @Basic
    @Column(name = "order_number", nullable = true, length = 128)
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "order_lasttime", nullable = true)
    public Timestamp getOrderLasttime() {
        return orderLasttime;
    }

    public void setOrderLasttime(Timestamp orderLasttime) {
        this.orderLasttime = orderLasttime;
    }

    @Basic
    @Column(name = "order_delay", nullable = true)
    public Integer getOrderDelay() {
        return orderDelay;
    }

    public void setOrderDelay(Integer orderDelay) {
        this.orderDelay = orderDelay;
    }

    @Basic
    @Column(name = "createAt", nullable = true)
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "updateAt", nullable = true)
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Basic
    @Column(name = "order_address", nullable = true, length = 128)
    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    @Basic
    @Column(name = "order_addressphone", nullable = true, length = 15)
    public String getOrderAddressphone() {
        return orderAddressphone;
    }

    public void setOrderAddressphone(String orderAddressphone) {
        this.orderAddressphone = orderAddressphone;
    }

    @Basic
    @Column(name = "order_addressusername", nullable = true, length = 15)
    public String getOrderAddressusername() {
        return orderAddressusername;
    }

    public void setOrderAddressusername(String orderAddressusername) {
        this.orderAddressusername = orderAddressusername;
    }

    @Basic
    @Column(name = "order_status", nullable = true)
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(orderUserid, that.orderUserid) &&
                Objects.equals(orderTotalprice, that.orderTotalprice) &&
                Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(orderLasttime, that.orderLasttime) &&
                Objects.equals(orderDelay, that.orderDelay) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt) &&
                Objects.equals(orderAddress, that.orderAddress) &&
                Objects.equals(orderAddressphone, that.orderAddressphone) &&
                Objects.equals(orderAddressusername, that.orderAddressusername) &&
                Objects.equals(orderStatus, that.orderStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, orderUserid, orderTotalprice, orderNumber, orderLasttime, orderDelay, createAt, updateAt, orderAddress, orderAddressphone, orderAddressusername, orderStatus);
    }
}
