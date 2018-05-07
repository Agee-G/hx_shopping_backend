package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/26 上午11:26
 */
@Entity
@Table(name = "remark", schema = "hxtaobaocom", catalog = "")
public class RemarkEntity {
    private String remarkId;
    private Integer remarkLevel;
    private String remarkDetail;
    private String remarkGoodsid;
    private String remarkStatus;
    private String remarkUserid;
    private Timestamp createAt;
    private Timestamp updateAt;

    public RemarkEntity() {
    }

    public RemarkEntity(Integer remarkLevel, String remarkDetail, String remarkGoodsid, String remarkStatus, String remarkUserid) {


        this.remarkLevel = remarkLevel;
        this.remarkDetail = remarkDetail;
        this.remarkGoodsid = remarkGoodsid;
        this.remarkStatus = remarkStatus;
        this.remarkUserid = remarkUserid;
    }



    @Id
    @Column(name = "remark_id")
    public String getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(String remarkId) {
        this.remarkId = remarkId;
    }

    @Basic
    @Column(name = "remark_level")
    public Integer getRemarkLevel() {
        return remarkLevel;
    }

    public void setRemarkLevel(Integer remarkLevel) {
        this.remarkLevel = remarkLevel;
    }

    @Basic
    @Column(name = "remark_detail")
    public String getRemarkDetail() {
        return remarkDetail;
    }

    public void setRemarkDetail(String remarkDetail) {
        this.remarkDetail = remarkDetail;
    }

    @Basic
    @Column(name = "remark_goodsid")
    public String getRemarkGoodsid() {
        return remarkGoodsid;
    }

    public void setRemarkGoodsid(String remarkGoodsid) {
        this.remarkGoodsid = remarkGoodsid;
    }

    @Basic
    @Column(name = "remark_status")
    public String getRemarkStatus() {
        return remarkStatus;
    }

    public void setRemarkStatus(String remarkStatus) {
        this.remarkStatus = remarkStatus;
    }

    @Basic
    @Column(name = "remark_userid")
    public String getRemarkUserid() {
        return remarkUserid;
    }

    public void setRemarkUserid(String remarkUserid) {
        this.remarkUserid = remarkUserid;
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

        RemarkEntity that = (RemarkEntity) o;

        if (remarkId != null ? !remarkId.equals(that.remarkId) : that.remarkId != null) return false;
        if (remarkLevel != null ? !remarkLevel.equals(that.remarkLevel) : that.remarkLevel != null) return false;
        if (remarkDetail != null ? !remarkDetail.equals(that.remarkDetail) : that.remarkDetail != null) return false;
        if (remarkGoodsid != null ? !remarkGoodsid.equals(that.remarkGoodsid) : that.remarkGoodsid != null)
            return false;
        if (remarkStatus != null ? !remarkStatus.equals(that.remarkStatus) : that.remarkStatus != null) return false;
        if (remarkUserid != null ? !remarkUserid.equals(that.remarkUserid) : that.remarkUserid != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = remarkId != null ? remarkId.hashCode() : 0;
        result = 31 * result + (remarkLevel != null ? remarkLevel.hashCode() : 0);
        result = 31 * result + (remarkDetail != null ? remarkDetail.hashCode() : 0);
        result = 31 * result + (remarkGoodsid != null ? remarkGoodsid.hashCode() : 0);
        result = 31 * result + (remarkStatus != null ? remarkStatus.hashCode() : 0);
        result = 31 * result + (remarkUserid != null ? remarkUserid.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
