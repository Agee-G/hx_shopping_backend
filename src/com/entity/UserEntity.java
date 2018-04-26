package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author:lily
 * @date:18/4/20 22 05
 * @description
 */
@Entity
@Table(name = "user", schema = "hxtaobaocom")
public class UserEntity {
    private String userId;
    private String userAccount;
    private String userPassword;
    private String userNickname;
    private Integer userTotalscore = 0;
    private Integer userScore = 0;
    private Integer userBalance = 0;
    private String userBankcard;
    private Integer userLevel = 2;
    private String userStatus;
    private Timestamp createAt;
    private Timestamp updateAt;

    @Id
    @Column(name = "user_id", nullable = false, length = 128)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_account", nullable = true, length = 20)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "user_password", nullable = true, length = 128)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_nickname", nullable = true, length = 20)
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Basic
    @Column(name = "user_totalscore", nullable = true)
    public Integer getUserTotalscore() {
        return userTotalscore;
    }

    public void setUserTotalscore(Integer userTotalscore) {
        this.userTotalscore = userTotalscore;
    }

    @Basic
    @Column(name = "user_score", nullable = true)
    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    @Basic
    @Column(name = "user_balance", nullable = true)
    public Integer getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Integer userBalance) {
        this.userBalance = userBalance;
    }

    @Basic
    @Column(name = "user_bankcard", nullable = true, length = 20)
    public String getUserBankcard() {
        return userBankcard;
    }

    public void setUserBankcard(String userBankcard) {
        this.userBankcard = userBankcard;
    }

    @Basic
    @Column(name = "user_level", nullable = true)
    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    @Basic
    @Column(name = "user_status", nullable = true)
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
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
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(userAccount, that.userAccount) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(userNickname, that.userNickname) &&
                Objects.equals(userTotalscore, that.userTotalscore) &&
                Objects.equals(userScore, that.userScore) &&
                Objects.equals(userBalance, that.userBalance) &&
                Objects.equals(userBankcard, that.userBankcard) &&
                Objects.equals(userLevel, that.userLevel) &&
                Objects.equals(userStatus, that.userStatus) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, userAccount, userPassword, userNickname, userTotalscore, userScore, userBalance, userBankcard, userLevel, userStatus, createAt, updateAt);
    }
}
