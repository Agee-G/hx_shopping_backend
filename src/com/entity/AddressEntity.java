package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/26 上午11:26
 */
@Entity
@Table(name = "address", schema = "hxtaobaocom", catalog = "")
public class AddressEntity {
    private String addressId;
    private String address;
    private String addressUsername;
    private String addressPhone;
    private String addressUser;
    private Integer addressLevel;
    private Timestamp createAt;
    private Timestamp updateAt;

    @Id
    @Column(name = "address_id")
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "address_username")
    public String getAddressUsername() {
        return addressUsername;
    }

    public void setAddressUsername(String addressUsername) {
        this.addressUsername = addressUsername;
    }

    @Basic
    @Column(name = "address_phone")
    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    @Basic
    @Column(name = "address_user")
    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    @Basic
    @Column(name = "address_level")
    public Integer getAddressLevel() {
        return addressLevel;
    }

    public void setAddressLevel(Integer addressLevel) {
        this.addressLevel = addressLevel;
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

        AddressEntity that = (AddressEntity) o;

        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (addressUsername != null ? !addressUsername.equals(that.addressUsername) : that.addressUsername != null)
            return false;
        if (addressPhone != null ? !addressPhone.equals(that.addressPhone) : that.addressPhone != null) return false;
        if (addressUser != null ? !addressUser.equals(that.addressUser) : that.addressUser != null) return false;
        if (addressLevel != null ? !addressLevel.equals(that.addressLevel) : that.addressLevel != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId != null ? addressId.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (addressUsername != null ? addressUsername.hashCode() : 0);
        result = 31 * result + (addressPhone != null ? addressPhone.hashCode() : 0);
        result = 31 * result + (addressUser != null ? addressUser.hashCode() : 0);
        result = 31 * result + (addressLevel != null ? addressLevel.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
