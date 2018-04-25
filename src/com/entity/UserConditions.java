package com.entity;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 25/04/201808:17
 */
public class UserConditions {
    private String user_account;
    private String user_password;
    private String user_nickname;
    private Integer user_totalscore;
    private Integer user_level;
    private Integer user_status;

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_nickname() {
        return "%"+user_nickname+"%";
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public Integer getUser_totalscore() {
        return user_totalscore;
    }

    public void setUser_totalscore(Integer user_totalscore) {
        this.user_totalscore = user_totalscore;
    }

    public Integer getUser_level() {
        return user_level;
    }

    public void setUser_level(Integer user_level) {
        this.user_level = user_level;
    }

    public Integer getUser_status() {
        return user_status;
    }

    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }
}
