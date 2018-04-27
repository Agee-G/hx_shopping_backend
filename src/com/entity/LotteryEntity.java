package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/26 上午11:26
 */
@Entity
@Table(name = "lottery", schema = "hxtaobaocom", catalog = "")
public class LotteryEntity {
    private String lotteryId;
    private String lotteryDetail;
    private Timestamp createAt;
    private String lotteryUser;
    private Timestamp updateAt;

    @Id
    @Column(name = "lottery_id")
    public String getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(String lotteryId) {
        this.lotteryId = lotteryId;
    }

    @Basic
    @Column(name = "lottery_detail")
    public String getLotteryDetail() {
        return lotteryDetail;
    }

    public void setLotteryDetail(String lotteryDetail) {
        this.lotteryDetail = lotteryDetail;
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
    @Column(name = "lottery_user")
    public String getLotteryUser() {
        return lotteryUser;
    }

    public void setLotteryUser(String lotteryUser) {
        this.lotteryUser = lotteryUser;
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

        LotteryEntity that = (LotteryEntity) o;

        if (lotteryId != null ? !lotteryId.equals(that.lotteryId) : that.lotteryId != null) return false;
        if (lotteryDetail != null ? !lotteryDetail.equals(that.lotteryDetail) : that.lotteryDetail != null)
            return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (lotteryUser != null ? !lotteryUser.equals(that.lotteryUser) : that.lotteryUser != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lotteryId != null ? lotteryId.hashCode() : 0;
        result = 31 * result + (lotteryDetail != null ? lotteryDetail.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (lotteryUser != null ? lotteryUser.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
