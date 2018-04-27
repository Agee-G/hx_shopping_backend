package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/26 上午11:26
 */
@Entity
@Table(name = "ordergoods", schema = "hxtaobaocom", catalog = "")
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
    @Column(name = "ordergoods_id")
    public String getOrdergoodsId() {
        return ordergoodsId;
    }

    public void setOrdergoodsId(String ordergoodsId) {
        this.ordergoodsId = ordergoodsId;
    }

    @Basic
    @Column(name = "ordergoods_name")
    public String getOrdergoodsName() {
        return ordergoodsName;
    }

    public void setOrdergoodsName(String ordergoodsName) {
        this.ordergoodsName = ordergoodsName;
    }

    @Basic
    @Column(name = "ordergoods_picture")
    public String getOrdergoodsPicture() {
        return ordergoodsPicture;
    }

    public void setOrdergoodsPicture(String ordergoodsPicture) {
        this.ordergoodsPicture = ordergoodsPicture;
    }

    @Basic
    @Column(name = "ordergoods_num")
    public Integer getOrdergoodsNum() {
        return ordergoodsNum;
    }

    public void setOrdergoodsNum(Integer ordergoodsNum) {
        this.ordergoodsNum = ordergoodsNum;
    }

    @Basic
    @Column(name = "ordergoods_style")
    public String getOrdergoodsStyle() {
        return ordergoodsStyle;
    }

    public void setOrdergoodsStyle(String ordergoodsStyle) {
        this.ordergoodsStyle = ordergoodsStyle;
    }

    @Basic
    @Column(name = "ordergoods_price")
    public Integer getOrdergoodsPrice() {
        return ordergoodsPrice;
    }

    public void setOrdergoodsPrice(Integer ordergoodsPrice) {
        this.ordergoodsPrice = ordergoodsPrice;
    }

    @Basic
    @Column(name = "ordergoods_ordernum")
    public String getOrdergoodsOrdernum() {
        return ordergoodsOrdernum;
    }

    public void setOrdergoodsOrdernum(String ordergoodsOrdernum) {
        this.ordergoodsOrdernum = ordergoodsOrdernum;
    }

    @Basic
    @Column(name = "ordergoods_merchant")
    public String getOrdergoodsMerchant() {
        return ordergoodsMerchant;
    }

    public void setOrdergoodsMerchant(String ordergoodsMerchant) {
        this.ordergoodsMerchant = ordergoodsMerchant;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdergoodsEntity that = (OrdergoodsEntity) o;

        if (ordergoodsId != null ? !ordergoodsId.equals(that.ordergoodsId) : that.ordergoodsId != null) return false;
        if (ordergoodsName != null ? !ordergoodsName.equals(that.ordergoodsName) : that.ordergoodsName != null)
            return false;
        if (ordergoodsPicture != null ? !ordergoodsPicture.equals(that.ordergoodsPicture) : that.ordergoodsPicture != null)
            return false;
        if (ordergoodsNum != null ? !ordergoodsNum.equals(that.ordergoodsNum) : that.ordergoodsNum != null)
            return false;
        if (ordergoodsStyle != null ? !ordergoodsStyle.equals(that.ordergoodsStyle) : that.ordergoodsStyle != null)
            return false;
        if (ordergoodsPrice != null ? !ordergoodsPrice.equals(that.ordergoodsPrice) : that.ordergoodsPrice != null)
            return false;
        if (ordergoodsOrdernum != null ? !ordergoodsOrdernum.equals(that.ordergoodsOrdernum) : that.ordergoodsOrdernum != null)
            return false;
        if (ordergoodsMerchant != null ? !ordergoodsMerchant.equals(that.ordergoodsMerchant) : that.ordergoodsMerchant != null)
            return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ordergoodsId != null ? ordergoodsId.hashCode() : 0;
        result = 31 * result + (ordergoodsName != null ? ordergoodsName.hashCode() : 0);
        result = 31 * result + (ordergoodsPicture != null ? ordergoodsPicture.hashCode() : 0);
        result = 31 * result + (ordergoodsNum != null ? ordergoodsNum.hashCode() : 0);
        result = 31 * result + (ordergoodsStyle != null ? ordergoodsStyle.hashCode() : 0);
        result = 31 * result + (ordergoodsPrice != null ? ordergoodsPrice.hashCode() : 0);
        result = 31 * result + (ordergoodsOrdernum != null ? ordergoodsOrdernum.hashCode() : 0);
        result = 31 * result + (ordergoodsMerchant != null ? ordergoodsMerchant.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
