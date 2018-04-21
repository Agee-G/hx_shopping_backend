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
@Table(name = "shoppingcart", schema = "hxtaobaocom")
public class ShoppingcartEntity {
    private String shoppingcartId;
    private String shoppingcartStoreid;
    private String shoppingcartGoodsid;
    private Integer shoppingcartGoodsnum;
    private String shoppingcartUser;
    private String shoppingcartGoodsStyle;
    private Timestamp createAt;
    private Timestamp updateAt;

    @Id
    @Column(name = "shoppingcart_id", nullable = false, length = 128)
    public String getShoppingcartId() {
        return shoppingcartId;
    }

    public void setShoppingcartId(String shoppingcartId) {
        this.shoppingcartId = shoppingcartId;
    }

    @Basic
    @Column(name = "shoppingcart_storeid", nullable = false, length = 128)
    public String getShoppingcartStoreid() {
        return shoppingcartStoreid;
    }

    public void setShoppingcartStoreid(String shoppingcartStoreid) {
        this.shoppingcartStoreid = shoppingcartStoreid;
    }

    @Basic
    @Column(name = "shoppingcart_goodsid", nullable = true, length = 128)
    public String getShoppingcartGoodsid() {
        return shoppingcartGoodsid;
    }

    public void setShoppingcartGoodsid(String shoppingcartGoodsid) {
        this.shoppingcartGoodsid = shoppingcartGoodsid;
    }

    @Basic
    @Column(name = "shoppingcart_goodsnum", nullable = true)
    public Integer getShoppingcartGoodsnum() {
        return shoppingcartGoodsnum;
    }

    public void setShoppingcartGoodsnum(Integer shoppingcartGoodsnum) {
        this.shoppingcartGoodsnum = shoppingcartGoodsnum;
    }

    @Basic
    @Column(name = "shoppingcart_user", nullable = true, length = 128)
    public String getShoppingcartUser() {
        return shoppingcartUser;
    }

    public void setShoppingcartUser(String shoppingcartUser) {
        this.shoppingcartUser = shoppingcartUser;
    }

    @Basic
    @Column(name = "shoppingcart_goodsStyle", nullable = true, length = 20)
    public String getShoppingcartGoodsStyle() {
        return shoppingcartGoodsStyle;
    }

    public void setShoppingcartGoodsStyle(String shoppingcartGoodsStyle) {
        this.shoppingcartGoodsStyle = shoppingcartGoodsStyle;
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
        ShoppingcartEntity that = (ShoppingcartEntity) o;
        return Objects.equals(shoppingcartId, that.shoppingcartId) &&
                Objects.equals(shoppingcartStoreid, that.shoppingcartStoreid) &&
                Objects.equals(shoppingcartGoodsid, that.shoppingcartGoodsid) &&
                Objects.equals(shoppingcartGoodsnum, that.shoppingcartGoodsnum) &&
                Objects.equals(shoppingcartUser, that.shoppingcartUser) &&
                Objects.equals(shoppingcartGoodsStyle, that.shoppingcartGoodsStyle) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shoppingcartId, shoppingcartStoreid, shoppingcartGoodsid, shoppingcartGoodsnum, shoppingcartUser, shoppingcartGoodsStyle, createAt, updateAt);
    }
}
