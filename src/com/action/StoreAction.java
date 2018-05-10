package com.action;

import com.Utils.MD5;
import com.biz.StoreBiz;
import com.entity.StoreConditions;
import com.entity.StoreEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;
import java.util.List;


/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 09/05/201816:00
 */
@ParentPackage("json-default")
public class StoreAction extends ActionSupport {
    private String storeId;
    private String storeAccount;
    private String storePassword;
    private String storeName;
    private String storePicture;
    private Double storeBalance;




    private int code = 0;
    private String message;
    private HashMap data = new HashMap();
    @JSON(serialize=false)
    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    @JSON(serialize=false)
    public String getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(String storeAccount) {
        this.storeAccount = storeAccount;
    }
    @JSON(serialize=false)
    public String getStorePassword() {
        return storePassword;
    }

    public void setStorePassword(String storePassword) {
        this.storePassword = storePassword;
    }
    @JSON(serialize=false)
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    @JSON(serialize=false)
    public String getStorePicture() {
        return storePicture;
    }

    public void setStorePicture(String storePicture) {
        this.storePicture = storePicture;
    }
    @JSON(serialize=false)
    public Double getStoreBalance() {
        return storeBalance;
    }

    public void setStoreBalance(Double storeBalance) {
        this.storeBalance = storeBalance;
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
            case 331:
                message = "商家名和密码错误";
                break;
            case 332:
                message = "用户名已经注册。";
                break;
            case 333:
                message = "传参有缺失";
                break;
            case 334:
                message = "已经提交申诉";
                break;
            case 335:
                message = "未提交申诉";
                break;
            case 340:
                message = "修改成功";
                break;
            case 341:
                message = "查询成功";
                break;
            default:
                message = "出现了未知错误";
                break;
        }
    }

    @Action(value = "addNewStore",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String addNewStore()throws Exception{
        StoreBiz storeBiz = new StoreBiz();
        if (storeAccount != null&&storePassword != null&&storeName != null){
            StoreEntity storeEntity = new StoreEntity();
            storeEntity.setStoreAccount(storeAccount);
            storeEntity.setStorePassword(storePassword);
            storeEntity.setStoreName(storeName);
            storeBiz.addNewStore(storeEntity);
            code = 1;
        }else {
            code = 333;
        }
        setMessageByCode();
        return SUCCESS;
    }

    @Action(value = "findStoreApplyCount",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String findStoreApplyCount()throws Exception{
        StoreBiz storeBiz = new StoreBiz();
        if (storeId!= null){
            StoreEntity storeEntity = new StoreEntity();
            storeEntity.setStoreId(storeId);
            Integer count = storeBiz.findStoreApplyCount(storeEntity);
            if (count > 0) {
                code = 334;
            }else {
                code = 335;
            }
        }else {
            code = 333;
        }
        setMessageByCode();
        return SUCCESS;
    }
    @Action(value = "storeLogin",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String storeLogin()throws Exception{
        StoreBiz storeBiz = new StoreBiz();
        if (storeAccount != null&&storePassword != null){
            StoreConditions storeConditions = new StoreConditions();
            storeConditions.setStore_account(storeAccount);
            storeConditions.setStore_password(MD5.string2MD5(storePassword));
            List<StoreEntity> storeEntityList = storeBiz.storeLogin(storeConditions);
            if (storeEntityList.size() != 0){
                code = 2;
            }else {
                code = 331;
            }
        }else {
            code = 333;
        }
        setMessageByCode();
        return SUCCESS;
    }
    @Action(value = "updateStore",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String updateStore()throws Exception{
        StoreBiz storeBiz = new StoreBiz();
        StoreEntity storeEntity = new StoreEntity();
        if (storeId != null) {
            storeEntity.setStoreId(storeId);
            if (storeName != null) {
                storeEntity.setStoreName(storeName);
            }
            if (storePassword != null) {
                storeEntity.setStorePassword(storePassword);
            }
            if (storeBalance != null) {
                storeEntity.setStoreBalance(storeBalance);
            }
            if (storePicture != null) {
                storeEntity.setStorePicture(storePicture);
            }
            storeBiz.updateStore(storeEntity);
            code = 340;
        }else {
            code = 333;
        }
        setMessageByCode();
        return SUCCESS;
    }
    @Action(value = "findStore",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String findStore()throws Exception{
        StoreBiz storeBiz = new StoreBiz();
        if (storeId != null){
            StoreEntity storeEntity = storeBiz.getStore(storeId);
            data.put("store",storeEntity);
            code = 341;
        }else {
            code = 333;
        }
        return SUCCESS;
    }

}
