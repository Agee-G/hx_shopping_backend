package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/26 上午11:26
 */
@Entity
@Table(name = "shoppingcart", schema = "hxtaobaocom", catalog = "")
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
    @Column(name = "shoppingcart_id")
    public String getShoppingcartId() {
        return shoppingcartId;
    }

    public void setShoppingcartId(String shoppingcartId) {
        this.shoppingcartId = shoppingcartId;
    }

    @Basic
    @Column(name = "shoppingcart_storeid")
    public String getShoppingcartStoreid() {
        return shoppingcartStoreid;
    }

    public void setShoppingcartStoreid(String shoppingcartStoreid) {
        this.shoppingcartStoreid = shoppingcartStoreid;
    }

    @Basic
    @Column(name = "shoppingcart_goodsid")
    public String getShoppingcartGoodsid() {
        return shoppingcartGoodsid;
    }

    public void setShoppingcartGoodsid(String shoppingcartGoodsid) {
        this.shoppingcartGoodsid = shoppingcartGoodsid;
    }

    @Basic
    @Column(name = "shoppingcart_goodsnum")
    public Integer getShoppingcartGoodsnum() {
        return shoppingcartGoodsnum;
    }

    public void setShoppingcartGoodsnum(Integer shoppingcartGoodsnum) {
        this.shoppingcartGoodsnum = shoppingcartGoodsnum;
    }

    @Basic
    @Column(name = "shoppingcart_user")
    public String getShoppingcartUser() {
        return shoppingcartUser;
    }

    public void setShoppingcartUser(String shoppingcartUser) {
        this.shoppingcartUser = shoppingcartUser;
    }

    @Basic
    @Column(name = "shoppingcart_goodsStyle")
    public String getShoppingcartGoodsStyle() {
        return shoppingcartGoodsStyle;
    }

    public void setShoppingcartGoodsStyle(String shoppingcartGoodsStyle) {
        this.shoppingcartGoodsStyle = shoppingcartGoodsStyle;
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

        ShoppingcartEntity that = (ShoppingcartEntity) o;

        if (shoppingcartId != null ? !shoppingcartId.equals(that.shoppingcartId) : that.shoppingcartId != null)
            return false;
        if (shoppingcartStoreid != null ? !shoppingcartStoreid.equals(that.shoppingcartStoreid) : that.shoppingcartStoreid != null)
            return false;
        if (shoppingcartGoodsid != null ? !shoppingcartGoodsid.equals(that.shoppingcartGoodsid) : that.shoppingcartGoodsid != null)
            return false;
        if (shoppingcartGoodsnum != null ? !shoppingcartGoodsnum.equals(that.shoppingcartGoodsnum) : that.shoppingcartGoodsnum != null)
            return false;
        if (shoppingcartUser != null ? !shoppingcartUser.equals(that.shoppingcartUser) : that.shoppingcartUser != null)
            return false;
        if (shoppingcartGoodsStyle != null ? !shoppingcartGoodsStyle.equals(that.shoppingcartGoodsStyle) : that.shoppingcartGoodsStyle != null)
            return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shoppingcartId != null ? shoppingcartId.hashCode() : 0;
        result = 31 * result + (shoppingcartStoreid != null ? shoppingcartStoreid.hashCode() : 0);
        result = 31 * result + (shoppingcartGoodsid != null ? shoppingcartGoodsid.hashCode() : 0);
        result = 31 * result + (shoppingcartGoodsnum != null ? shoppingcartGoodsnum.hashCode() : 0);
        result = 31 * result + (shoppingcartUser != null ? shoppingcartUser.hashCode() : 0);
        result = 31 * result + (shoppingcartGoodsStyle != null ? shoppingcartGoodsStyle.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
