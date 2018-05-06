package com.action;

import com.Utils.MD5;
import com.biz.BackendBiz;
import com.entity.UserConditions;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 03/05/201811:21
 */
@ParentPackage("json-default")
public class BackendAction extends ActionSupport{
    private String adminId;
    private String adminAccount;
    private String adminPassword;



    private int code = 0;
    private String message;
    private HashMap data = new HashMap();

    @JSON(serialize=false)
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    @JSON(serialize=false)
    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }
    @JSON(serialize=false)
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
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
            case 2:
                message = "登录成功";
                code = 0;
                break;
            case 311:
                message = "用户名和密码错误了诶~ 换一个试试咩(*^▽^*)";
                break;
            case 313:
                message = "用户名被人注册了呢o(╥﹏╥)o,慢了一步 呜呜。";
                break;
            case 320:
                message = "您好，徐先生，您的传参有缺失哦~";
                break;
            default:
                message = "出现了未知错误咩~哭兮兮o(╥﹏╥)o";
                break;
        }
    }
    @Action(value = "adminLogin",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String adminLogin()throws Exception{
        BackendBiz backendBiz = new BackendBiz();
        if (adminAccount == null || adminPassword == null){
            code = 320;
        }else {
            UserConditions userConditions = new UserConditions();
            adminPassword = MD5.string2MD5(adminPassword);
            userConditions.setUser_account(adminAccount);
            userConditions.setUser_password(adminPassword);

        }
        return SUCCESS;
    }
}
