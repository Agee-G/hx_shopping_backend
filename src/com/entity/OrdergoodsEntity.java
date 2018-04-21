package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author:lily
 * @date:18/4/20 22 04
 * @description
 */
@Entity
@Table(name = "ordergoods", schema = "hxtaobaocom")
public class OrdergoodsEntity {
    private String ordergoodsId;
    private String ordergoodsName;
    private String ordergoodsPicture;
    private Integer ordergoodsNum;
    private String ordergoodsStyle;
    private Integer ordergoodsPrice;
    private String ordergoodsOrdernum;
    private String ordergoodsMerchant;
    private Timestamp createAt;
    private Timestamp updateAt;

    @Id
    @Column(name = "ordergoods_id", nullable = false, length = 128)
    public String getOrdergoodsId() {
        return ordergoodsId;
    }

    public void setOrdergoodsId(String ordergoodsId) {
        this.ordergoodsId = ordergoodsId;
    }

    @Basic
    @Column(name = "ordergoods_name", nullable = true, length = 50)
    public String getOrdergoodsName() {
        return ordergoodsName;
    }

    public void setOrdergoodsName(String ordergoodsName) {
        this.ordergoodsName = ordergoodsName;
    }

    @Basic
    @Column(name = "ordergoods_picture", nullable = true, length = 20)
    public String getOrdergoodsPicture() {
        return ordergoodsPicture;
    }

    public void setOrdergoodsPicture(String ordergoodsPicture) {
        this.ordergoodsPicture = ordergoodsPicture;
    }

    @Basic
    @Column(name = "ordergoods_num", nullable = true)
    public Integer getOrdergoodsNum() {
        return ordergoodsNum;
    }

    public void setOrdergoodsNum(Integer ordergoodsNum) {
        this.ordergoodsNum = ordergoodsNum;
    }

    @Basic
    @Column(name = "ordergoods_style", nullable = true, length = 20)
    public String getOrdergoodsStyle() {
        return ordergoodsStyle;
    }

    public void setOrdergoodsStyle(String ordergoodsStyle) {
        this.ordergoodsStyle = ordergoodsStyle;
    }

    @Basic
    @Column(name = "ordergoods_price", nullable = true)
    public Integer getOrdergoodsPrice() {
        return ordergoodsPrice;
    }

    public void setOrdergoodsPrice(Integer ordergoodsPrice) {
        this.ordergoodsPrice = ordergoodsPrice;
    }

    @Basic
    @Column(name = "ordergoods_ordernum", nullable = true, length = 128)
    public String getOrdergoodsOrdernum() {
        return ordergoodsOrdernum;
    }

    public void setOrdergoodsOrdernum(String ordergoodsOrdernum) {
        this.ordergoodsOrdernum = ordergoodsOrdernum;
    }

    @Basic
    @Column(name = "ordergoods_merchant", nullable = true, length = 128)
    public String getOrdergoodsMerchant() {
        return ordergoodsMerchant;
    }

    public void setOrdergoodsMerchant(String ordergoodsMerchant) {
        this.ordergoodsMerchant = ordergoodsMerchant;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdergoodsEntity that = (OrdergoodsEntity) o;
        return Objects.equals(ordergoodsId, that.ordergoodsId) &&
                Objects.equals(ordergoodsName, that.ordergoodsName) &&
                Objects.equals(ordergoodsPicture, that.ordergoodsPicture) &&
                Objects.equals(ordergoodsNum, that.ordergoodsNum) &&
                Objects.equals(ordergoodsStyle, that.ordergoodsStyle) &&
                Objects.equals(ordergoodsPrice, that.ordergoodsPrice) &&
                Objects.equals(ordergoodsOrdernum, that.ordergoodsOrdernum) &&
                Objects.equals(ordergoodsMerchant, that.ordergoodsMerchant) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ordergoodsId, ordergoodsName, ordergoodsPicture, ordergoodsNum, ordergoodsStyle, ordergoodsPrice, ordergoodsOrdernum, ordergoodsMerchant, createAt, updateAt);
    }

    @Override
    public String toString() {
        return "OrdergoodsEntity{" +
                "ordergoodsId='" + ordergoodsId + '\'' +
                ", ordergoodsName='" + ordergoodsName + '\'' +
                ", ordergoodsPicture='" + ordergoodsPicture + '\'' +
                ", ordergoodsNum=" + ordergoodsNum +
                ", ordergoodsStyle='" + ordergoodsStyle + '\'' +
                ", ordergoodsPrice=" + ordergoodsPrice +
                ", ordergoodsOrdernum='" + ordergoodsOrdernum + '\'' +
                ", ordergoodsMerchant='" + ordergoodsMerchant + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
