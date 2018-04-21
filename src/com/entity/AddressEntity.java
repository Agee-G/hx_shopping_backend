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
@Table(name = "address", schema = "hxtaobaocom")
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
    @Column(name = "address_id", nullable = false, length = 128)
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "address_username", nullable = true, length = 15)
    public String getAddressUsername() {
        return addressUsername;
    }

    public void setAddressUsername(String addressUsername) {
        this.addressUsername = addressUsername;
    }

    @Basic
    @Column(name = "address_phone", nullable = true, length = 15)
    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    @Basic
    @Column(name = "address_user", nullable = true, length = 128)
    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    @Basic
    @Column(name = "address_level", nullable = true)
    public Integer getAddressLevel() {
        return addressLevel;
    }

    public void setAddressLevel(Integer addressLevel) {
        this.addressLevel = addressLevel;
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
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(addressId, that.addressId) &&
                Objects.equals(address, that.address) &&
                Objects.equals(addressUsername, that.addressUsername) &&
                Objects.equals(addressPhone, that.addressPhone) &&
                Objects.equals(addressUser, that.addressUser) &&
                Objects.equals(addressLevel, that.addressLevel) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(addressId, address, addressUsername, addressPhone, addressUser, addressLevel, createAt, updateAt);
    }
}
