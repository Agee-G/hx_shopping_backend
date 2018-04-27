package com.action;

import com.Utils.MD5;
import com.Utils.NicknameRandom;
import com.biz.UserBiz;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/25 下午2:38
 */
@ParentPackage("json-default")
public class UserAction extends ActionSupport{
    private String userId;
    private String userAccount;
    private String userPassword;
    private String userNickname;
    private Integer userTotalscore;
    private Integer userScore;
    private Double userBalance;
    private String userBankcard;
    private String userLevel;
    private String userStatus;
    private int code = 0;//code=0 :成功 ；code=xxx :错误码
    private String message;//用户看的错误信息
    private HashMap data = new HashMap();//返回的数据

    @JSON(serialize=false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    @JSON(serialize=false)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
    @JSON(serialize=false)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    @JSON(serialize=false)
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    @JSON(serialize=false)
    public Integer getUserTotalscore() {
        return userTotalscore;
    }

    public void setUserTotalscore(Integer userTotalscore) {
        this.userTotalscore = userTotalscore;
    }
    @JSON(serialize=false)
    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }
    @JSON(serialize=false)
    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }
    @JSON(serialize=false)
    public String getUserBankcard() {
        return userBankcard;
    }

    public void setUserBankcard(String userBankcard) {
        this.userBankcard = userBankcard;
    }
    @JSON(serialize=false)
    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
    @JSON(serialize=false)
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap getData() {
        return data;
    }

    public void setData(HashMap data) {
        this.data = data;
    }

    public void setMessageByCode(){
        switch (code){
            case 1:
                message = "注册成功";
                code = 0;
                break;
            case 420:
                message = "您好，徐先生，您的传参有缺失哦~";
                break;
            default:
                message = "出现了未知错误咩~哭兮兮o(╥﹏╥)o";
                break;
        }
    }
    //用户注册
    @Action(value = "addUser",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String addUser() throws Exception{

        UserBiz userBiz = new UserBiz();

        if(userAccount == null || userPassword == null ){
            code = 420;
        }else{
            UserEntity userEntity = new UserEntity();
            userEntity.setUserAccount(userAccount);
            //MD5加密
            userPassword = MD5.string2MD5(userPassword);
            userEntity.setUserPassword(userPassword);
            userEntity.setUserId(UUID.randomUUID().toString());
            if(userNickname == null){
                userNickname = NicknameRandom.nickname();
            }
            userEntity.setUserNickname(userNickname);
            userBiz.addUser(userEntity);
            code = 1;
        }
        setMessageByCode();
        return SUCCESS;

    }

}
