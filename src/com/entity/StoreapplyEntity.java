package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 22/04/201820:24
 */
@Entity
@Table(name = "storeapply", schema = "hxtaobaocom", catalog = "")
public class StoreapplyEntity {
    private String storeapplyId;
    private String storeapplyStoreid;
    private String storeapplyDetail;
    private Timestamp createAt;
    private Timestamp updateAt;
    private Integer storeapplyStatus;

    @Id
    @Column(name = "storeapply_id", nullable = false, length = 128)
    public String getStoreapplyId() {
        return storeapplyId;
    }

    public void setStoreapplyId(String storeapplyId) {
        this.storeapplyId = storeapplyId;
    }

    @Basic
    @Column(name = "storeapply_storeid", nullable = true, length = 128)
    public String getStoreapplyStoreid() {
        return storeapplyStoreid;
    }

    public void setStoreapplyStoreid(String storeapplyStoreid) {
        this.storeapplyStoreid = storeapplyStoreid;
    }

    @Basic
    @Column(name = "storeapply_detail", nullable = true, length = 50)
    public String getStoreapplyDetail() {
        return storeapplyDetail;
    }

    public void setStoreapplyDetail(String storeapplyDetail) {
        this.storeapplyDetail = storeapplyDetail;
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

    @Basic
    @Column(name = "storeapply_status", nullable = true)
    public Integer getStoreapplyStatus() {
        return storeapplyStatus;
    }

    public void setStoreapplyStatus(Integer storeapplyStatus) {
        this.storeapplyStatus = storeapplyStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreapplyEntity that = (StoreapplyEntity) o;

        if (storeapplyId != null ? !storeapplyId.equals(that.storeapplyId) : that.storeapplyId != null) return false;
        if (storeapplyStoreid != null ? !storeapplyStoreid.equals(that.storeapplyStoreid) : that.storeapplyStoreid != null)
            return false;
        if (storeapplyDetail != null ? !storeapplyDetail.equals(that.storeapplyDetail) : that.storeapplyDetail != null)
            return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;
        if (storeapplyStatus != null ? !storeapplyStatus.equals(that.storeapplyStatus) : that.storeapplyStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeapplyId != null ? storeapplyId.hashCode() : 0;
        result = 31 * result + (storeapplyStoreid != null ? storeapplyStoreid.hashCode() : 0);
        result = 31 * result + (storeapplyDetail != null ? storeapplyDetail.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        result = 31 * result + (storeapplyStatus != null ? storeapplyStatus.hashCode() : 0);
        return result;
    }
}
