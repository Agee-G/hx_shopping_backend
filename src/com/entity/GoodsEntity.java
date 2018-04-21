package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author:lily
 * @date:18/4/20 22 04
 * @description
 */
@Entity
@Table(name = "goods", schema = "hxtaobaocom")
public class GoodsEntity{
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
    @Column(name = "goods_id", nullable = false, length = 128)
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "goods_name", nullable = true, length = 100)
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goods_type", nullable = true)
    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    @Basic
    @Column(name = "goods_details", nullable = true, length = 128)
    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    @Basic
    @Column(name = "goods_price", nullable = true)
    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Basic
    @Column(name = "goods_storeid", nullable = true, length = 128)
    public String getGoodsStoreid() {
        return goodsStoreid;
    }

    public void setGoodsStoreid(String goodsStoreid) {
        this.goodsStoreid = goodsStoreid;
    }

    @Basic
    @Column(name = "goods_kucun", nullable = true)
    public Integer getGoodsKucun() {
        return goodsKucun;
    }

    public void setGoodsKucun(Integer goodsKucun) {
        this.goodsKucun = goodsKucun;
    }

    @Basic
    @Column(name = "goods_sell", nullable = true)
    public Integer getGoodsSell() {
        return goodsSell;
    }

    public void setGoodsSell(Integer goodsSell) {
        this.goodsSell = goodsSell;
    }

    @Basic
    @Column(name = "goods_picture", nullable = true, length = 128)
    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    @Basic
    @Column(name = "goods_style", nullable = true, length = 80)
    public String getGoodsStyle() {
        return goodsStyle;
    }

    public void setGoodsStyle(String goodsStyle) {
        this.goodsStyle = goodsStyle;
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
        GoodsEntity that = (GoodsEntity) o;
        return Objects.equals(goodsId, that.goodsId) &&
                Objects.equals(goodsName, that.goodsName) &&
                Objects.equals(goodsType, that.goodsType) &&
                Objects.equals(goodsDetails, that.goodsDetails) &&
                Objects.equals(goodsPrice, that.goodsPrice) &&
                Objects.equals(goodsStoreid, that.goodsStoreid) &&
                Objects.equals(goodsKucun, that.goodsKucun) &&
                Objects.equals(goodsSell, that.goodsSell) &&
                Objects.equals(goodsPicture, that.goodsPicture) &&
                Objects.equals(goodsStyle, that.goodsStyle) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(goodsId, goodsName, goodsType, goodsDetails, goodsPrice, goodsStoreid, goodsKucun, goodsSell, goodsPicture, goodsStyle, createAt, updateAt);
    }
}
