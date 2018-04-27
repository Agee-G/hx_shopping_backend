package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/26 上午11:26
 */
@Entity
@Table(name = "user", schema = "hxtaobaocom", catalog = "")
public class UserEntity {
    private String userId;
    private String userAccount;
    private String userPassword;
    private String userNickname;
    private Integer userTotalscore;
    private Integer userScore;
    private Double userBalance = 0.0;
    private String userBankcard;
    private String userLevel;
    private String userStatus;
    private Timestamp createAt;
    private Timestamp updateAt;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_account")
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_nickname")
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Basic
    @Column(name = "user_totalscore")
    public Integer getUserTotalscore() {
        return userTotalscore;
    }

    public void setUserTotalscore(Integer userTotalscore) {
        this.userTotalscore = userTotalscore;
    }

    @Basic
    @Column(name = "user_score")
    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    @Basic
    @Column(name = "user_balance")
    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    @Basic
    @Column(name = "user_bankcard")
    public String getUserBankcard() {
        return userBankcard;
    }

    public void setUserBankcard(String userBankcard) {
        this.userBankcard = userBankcard;
    }

    @Basic
    @Column(name = "user_level")
    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    @Basic
    @Column(name = "user_status")
    public String getUserStatus() {
        return userStatus;
    }

    public UserEntity() {
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
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

        UserEntity that = (UserEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userAccount != null ? !userAccount.equals(that.userAccount) : that.userAccount != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userNickname != null ? !userNickname.equals(that.userNickname) : that.userNickname != null) return false;
        if (userTotalscore != null ? !userTotalscore.equals(that.userTotalscore) : that.userTotalscore != null)
            return false;
        if (userScore != null ? !userScore.equals(that.userScore) : that.userScore != null) return false;
        if (userBalance != null ? !userBalance.equals(that.userBalance) : that.userBalance != null) return false;
        if (userBankcard != null ? !userBankcard.equals(that.userBankcard) : that.userBankcard != null) return false;
        if (userLevel != null ? !userLevel.equals(that.userLevel) : that.userLevel != null) return false;
        if (userStatus != null ? !userStatus.equals(that.userStatus) : that.userStatus != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userNickname != null ? userNickname.hashCode() : 0);
        result = 31 * result + (userTotalscore != null ? userTotalscore.hashCode() : 0);
        result = 31 * result + (userScore != null ? userScore.hashCode() : 0);
        result = 31 * result + (userBalance != null ? userBalance.hashCode() : 0);
        result = 31 * result + (userBankcard != null ? userBankcard.hashCode() : 0);
        result = 31 * result + (userLevel != null ? userLevel.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
