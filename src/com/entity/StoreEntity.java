package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/26 上午11:26
 */
@Entity
@Table(name = "store", schema = "hxtaobaocom", catalog = "")
public class StoreEntity {
    private String storeId;
    private String storeAccount;
    private String storePassword;
    private String storeName;
    private String storePicture;
    private Double storeBalance;
    private String storeStatus;
    private Timestamp createAt;
    private Timestamp updateAt;

    @Id
    @Column(name = "store_id")
    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "store_account")
    public String getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(String storeAccount) {
        this.storeAccount = storeAccount;
    }

    @Basic
    @Column(name = "store_password")
    public String getStorePassword() {
        return storePassword;
    }

    public void setStorePassword(String storePassword) {
        this.storePassword = storePassword;
    }

    @Basic
    @Column(name = "store_name")
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Basic
    @Column(name = "store_picture")
    public String getStorePicture() {
        return storePicture;
    }

    public void setStorePicture(String storePicture) {
        this.storePicture = storePicture;
    }

    @Basic
    @Column(name = "store_balance")
    public Double getStoreBalance() {
        return storeBalance;
    }

    public void setStoreBalance(Double storeBalance) {
        this.storeBalance = storeBalance;
    }

    @Basic
    @Column(name = "store_status")
    public String getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
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

        StoreEntity that = (StoreEntity) o;

        if (storeId != null ? !storeId.equals(that.storeId) : that.storeId != null) return false;
        if (storeAccount != null ? !storeAccount.equals(that.storeAccount) : that.storeAccount != null) return false;
        if (storePassword != null ? !storePassword.equals(that.storePassword) : that.storePassword != null)
            return false;
        if (storeName != null ? !storeName.equals(that.storeName) : that.storeName != null) return false;
        if (storePicture != null ? !storePicture.equals(that.storePicture) : that.storePicture != null) return false;
        if (storeBalance != null ? !storeBalance.equals(that.storeBalance) : that.storeBalance != null) return false;
        if (storeStatus != null ? !storeStatus.equals(that.storeStatus) : that.storeStatus != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeId != null ? storeId.hashCode() : 0;
        result = 31 * result + (storeAccount != null ? storeAccount.hashCode() : 0);
        result = 31 * result + (storePassword != null ? storePassword.hashCode() : 0);
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        result = 31 * result + (storePicture != null ? storePicture.hashCode() : 0);
        result = 31 * result + (storeBalance != null ? storeBalance.hashCode() : 0);
        result = 31 * result + (storeStatus != null ? storeStatus.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
