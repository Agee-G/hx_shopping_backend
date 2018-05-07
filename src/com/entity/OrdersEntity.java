package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/26 上午11:26
 */
@Entity
@Table(name = "orders", schema = "hxtaobaocom", catalog = "")
public class OrdersEntity {
    private String orderId;
    private String orderUserid;
    private String orderStoreid;
    private Double orderTotalprice;
    private String orderNumber;
    private Timestamp orderLasttime;
    private String orderDelay;
    private Timestamp createAt;
    private Timestamp updateAt;
    private String orderAddress;
    private String orderAddressphone;
    private String orderAddressusername;
    private String orderStatus;

    @Id
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_userid")
    public String getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(String orderUserid) {
        this.orderUserid = orderUserid;
    }

    @Basic
    @Column(name = "order_storeid")
    public String getOrderStoreid() {
        return orderStoreid;
    }

    public void setOrderStoreid(String orderStoreid) {
        this.orderStoreid = orderStoreid;
    }

    @Basic
    @Column(name = "order_totalprice")
    public Double getOrderTotalprice() {
        return orderTotalprice;
    }

    public void setOrderTotalprice(Double orderTotalprice) {
        this.orderTotalprice = orderTotalprice;
    }

    @Basic
    @Column(name = "order_number")
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "order_lasttime")
    public Timestamp getOrderLasttime() {
        return orderLasttime;
    }

    public void setOrderLasttime(Timestamp orderLasttime) {
        this.orderLasttime = orderLasttime;
    }

    @Basic
    @Column(name = "order_delay")
    public String getOrderDelay() {
        return orderDelay;
    }

    public void setOrderDelay(String orderDelay) {
        this.orderDelay = orderDelay;
    }

    @Basic
    @Column(name = "createAt")
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "updateAt")
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Basic
    @Column(name = "order_address")
    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    @Basic
    @Column(name = "order_addressphone")
    public String getOrderAddressphone() {
        return orderAddressphone;
    }

    public void setOrderAddressphone(String orderAddressphone) {
        this.orderAddressphone = orderAddressphone;
    }

    @Basic
    @Column(name = "order_addressusername")
    public String getOrderAddressusername() {
        return orderAddressusername;
    }

    public void setOrderAddressusername(String orderAddressusername) {
        this.orderAddressusername = orderAddressusername;
    }

    @Basic
    @Column(name = "order_status")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (orderUserid != null ? !orderUserid.equals(that.orderUserid) : that.orderUserid != null) return false;
        if (orderStoreid != null ? !orderStoreid.equals(that.orderStoreid) : that.orderStoreid != null) return false;
        if (orderTotalprice != null ? !orderTotalprice.equals(that.orderTotalprice) : that.orderTotalprice != null)
            return false;
        if (orderNumber != null ? !orderNumber.equals(that.orderNumber) : that.orderNumber != null) return false;
        if (orderLasttime != null ? !orderLasttime.equals(that.orderLasttime) : that.orderLasttime != null)
            return false;
        if (orderDelay != null ? !orderDelay.equals(that.orderDelay) : that.orderDelay != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;
        if (orderAddress != null ? !orderAddress.equals(that.orderAddress) : that.orderAddress != null) return false;
        if (orderAddressphone != null ? !orderAddressphone.equals(that.orderAddressphone) : that.orderAddressphone != null)
            return false;
        if (orderAddressusername != null ? !orderAddressusername.equals(that.orderAddressusername) : that.orderAddressusername != null)
            return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderUserid != null ? orderUserid.hashCode() : 0);
        result = 31 * result + (orderStoreid != null ? orderStoreid.hashCode() : 0);
        result = 31 * result + (orderTotalprice != null ? orderTotalprice.hashCode() : 0);
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (orderLasttime != null ? orderLasttime.hashCode() : 0);
        result = 31 * result + (orderDelay != null ? orderDelay.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        result = 31 * result + (orderAddress != null ? orderAddress.hashCode() : 0);
        result = 31 * result + (orderAddressphone != null ? orderAddressphone.hashCode() : 0);
        result = 31 * result + (orderAddressusername != null ? orderAddressusername.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        return result;
    }
}
