package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author:lily
 * @date:18/4/21 13 21
 * @description
 */
@Entity
@Table(name = "store", schema = "hxtaobaocom")
public class StoreEntity {
    private String storeId;
    private String storeAccount;
    private String storePassword;
    private String storeName;
    private String storePicture;
    private Integer storeBalance = 0;
    private Integer storeStatus = 1;
    private Timestamp createAt;
    private Timestamp updateAt;

    @Id
    @Column(name = "store_id", nullable = false, length = 128)
    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "store_account", nullable = true, length = 20)
    public String getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(String storeAccount) {
        this.storeAccount = storeAccount;
    }

    @Basic
    @Column(name = "store_password", nullable = true, length = 128)
    public String getStorePassword() {
        return storePassword;
    }

    public void setStorePassword(String storePassword) {
        this.storePassword = storePassword;
    }

    @Basic
    @Column(name = "store_name", nullable = true, length = 20)
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Basic
    @Column(name = "store_picture", nullable = true, length = 50)
    public String getStorePicture() {
        return storePicture;
    }

    public void setStorePicture(String storePicture) {
        this.storePicture = storePicture;
    }

    @Basic
    @Column(name = "store_balance", nullable = true)
    public Integer getStoreBalance() {
        return storeBalance;
    }

    public void setStoreBalance(Integer storeBalance) {
        this.storeBalance = storeBalance;
    }

    @Basic
    @Column(name = "store_status", nullable = true)
    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
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
        StoreEntity that = (StoreEntity) o;
        return Objects.equals(storeId, that.storeId) &&
                Objects.equals(storeAccount, that.storeAccount) &&
                Objects.equals(storePassword, that.storePassword) &&
                Objects.equals(storeName, that.storeName) &&
                Objects.equals(storePicture, that.storePicture) &&
                Objects.equals(storeBalance, that.storeBalance) &&
                Objects.equals(storeStatus, that.storeStatus) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(storeId, storeAccount, storePassword, storeName, storePicture, storeBalance, storeStatus, createAt, updateAt);
    }
}
