package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/26 上午11:26
 */
@Entity
@Table(name = "goods", schema = "hxtaobaocom", catalog = "")
public class GoodsEntity {
    private String goodsId;
    private String goodsName;
    private Integer goodsType;
    private String goodsDetails;
    private Integer goodsPrice;
    private String goodsStoreid;
    private Integer goodsKucun;
    private Integer goodsSell;
    private String goodsPicture;
    private String goodsStyle;
    private Timestamp createAt;
    private Timestamp updateAt;

    @Id
    @Column(name = "goods_id")
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goods_type")
    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    @Basic
    @Column(name = "goods_details")
    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    @Basic
    @Column(name = "goods_price")
    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Basic
    @Column(name = "goods_storeid")
    public String getGoodsStoreid() {
        return goodsStoreid;
    }

    public void setGoodsStoreid(String goodsStoreid) {
        this.goodsStoreid = goodsStoreid;
    }

    @Basic
    @Column(name = "goods_kucun")
    public Integer getGoodsKucun() {
        return goodsKucun;
    }

    public void setGoodsKucun(Integer goodsKucun) {
        this.goodsKucun = goodsKucun;
    }

    @Basic
    @Column(name = "goods_sell")
    public Integer getGoodsSell() {
        return goodsSell;
    }

    public void setGoodsSell(Integer goodsSell) {
        this.goodsSell = goodsSell;
    }

    @Basic
    @Column(name = "goods_picture")
    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    @Basic
    @Column(name = "goods_style")
    public String getGoodsStyle() {
        return goodsStyle;
    }

    public void setGoodsStyle(String goodsStyle) {
        this.goodsStyle = goodsStyle;
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

        GoodsEntity that = (GoodsEntity) o;

        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (goodsType != null ? !goodsType.equals(that.goodsType) : that.goodsType != null) return false;
        if (goodsDetails != null ? !goodsDetails.equals(that.goodsDetails) : that.goodsDetails != null) return false;
        if (goodsPrice != null ? !goodsPrice.equals(that.goodsPrice) : that.goodsPrice != null) return false;
        if (goodsStoreid != null ? !goodsStoreid.equals(that.goodsStoreid) : that.goodsStoreid != null) return false;
        if (goodsKucun != null ? !goodsKucun.equals(that.goodsKucun) : that.goodsKucun != null) return false;
        if (goodsSell != null ? !goodsSell.equals(that.goodsSell) : that.goodsSell != null) return false;
        if (goodsPicture != null ? !goodsPicture.equals(that.goodsPicture) : that.goodsPicture != null) return false;
        if (goodsStyle != null ? !goodsStyle.equals(that.goodsStyle) : that.goodsStyle != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodsId != null ? goodsId.hashCode() : 0;
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsType != null ? goodsType.hashCode() : 0);
        result = 31 * result + (goodsDetails != null ? goodsDetails.hashCode() : 0);
        result = 31 * result + (goodsPrice != null ? goodsPrice.hashCode() : 0);
        result = 31 * result + (goodsStoreid != null ? goodsStoreid.hashCode() : 0);
        result = 31 * result + (goodsKucun != null ? goodsKucun.hashCode() : 0);
        result = 31 * result + (goodsSell != null ? goodsSell.hashCode() : 0);
        result = 31 * result + (goodsPicture != null ? goodsPicture.hashCode() : 0);
        result = 31 * result + (goodsStyle != null ? goodsStyle.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
