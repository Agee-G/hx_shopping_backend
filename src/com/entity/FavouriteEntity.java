package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/26 上午11:26
 */
@Entity
@Table(name = "favourite", schema = "hxtaobaocom", catalog = "")
public class FavouriteEntity {
    private String favouriteId;
    private String favouriteGoods;
    private String favouriteUser;
    private Timestamp createAt;
    private Timestamp updateAt;

    @Id
    @Column(name = "favourite_id")
    public String getFavouriteId() {
        return favouriteId;
    }

    public void setFavouriteId(String favouriteId) {
        this.favouriteId = favouriteId;
    }

    @Basic
    @Column(name = "favourite_goods")
    public String getFavouriteGoods() {
        return favouriteGoods;
    }

    public void setFavouriteGoods(String favouriteGoods) {
        this.favouriteGoods = favouriteGoods;
    }

    @Basic
    @Column(name = "favourite_user")
    public String getFavouriteUser() {
        return favouriteUser;
    }

    public void setFavouriteUser(String favouriteUser) {
        this.favouriteUser = favouriteUser;
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

        FavouriteEntity that = (FavouriteEntity) o;

        if (favouriteId != null ? !favouriteId.equals(that.favouriteId) : that.favouriteId != null) return false;
        if (favouriteGoods != null ? !favouriteGoods.equals(that.favouriteGoods) : that.favouriteGoods != null)
            return false;
        if (favouriteUser != null ? !favouriteUser.equals(that.favouriteUser) : that.favouriteUser != null)
            return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = favouriteId != null ? favouriteId.hashCode() : 0;
        result = 31 * result + (favouriteGoods != null ? favouriteGoods.hashCode() : 0);
        result = 31 * result + (favouriteUser != null ? favouriteUser.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
