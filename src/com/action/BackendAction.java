package com.action;

import com.Utils.MD5;
import com.Utils.Page;
import com.biz.BackendBiz;
import com.entity.StoreConditions;
import com.entity.StoreEntity;
import com.entity.UserConditions;
import com.entity.UserEntity;
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
 * @date 03/05/201811:21
 */
@ParentPackage("json-default")
public class BackendAction extends ActionSupport{
    private String storeId;
    private String userId;
    private String adminId;

    private String adminAccount;
    private String userAccount;
    private String storeAccount;

    private String adminPassword;

    private String userNickname;
    private String storeName;

    private Integer userTotalscore;

    private Integer pageSize;
    private Integer currentPage;

    private String userStatus;
    private String storeStatus;




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

    @JSON(serialize=false)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
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
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
    @JSON(serialize=false)
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    @JSON(serialize=false)
    public Integer getCurrentPage() {
        return currentPage;
    }

    @JSON(serialize=false)
    public String getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(String storeAccount) {
        this.storeAccount = storeAccount;
    }
    @JSON(serialize=false)
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    @JSON(serialize=false)
    public String getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    @JSON(serialize=false)
    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    @JSON(serialize=false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
                message = "用户名和密码错误";
                break;
            case 312:
                message = "用户名已经注册。";
                break;
            case 313:
                message = "传参有缺失";
                break;
            case 320:
                message = "修改成功";
                break;
            case 321:
                message = "查询成功";
                break;
            default:
                message = "出现了未知错误";
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
            code = 313;
        }else {
            UserConditions userConditions = new UserConditions();
            adminPassword = MD5.string2MD5(adminPassword);
            userConditions.setUser_account(adminAccount);
            userConditions.setUser_password(adminPassword);
            List<UserEntity> userEntity = backendBiz.adminLogin(userConditions);
            if (userEntity.size()==0){
                code = 311;
            }else {
                code = 2;
            }
        }
        setMessageByCode();
        return SUCCESS;
    }

    @Action(value = "findUsersByConditionsByPage",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String findUsersByConditionsByPage()throws Exception{
        BackendBiz backendBiz = new BackendBiz();
        Page<UserEntity> page = new Page<UserEntity>();
        if (pageSize != null && currentPage != null){
            page.setPageSize(pageSize);
            page.setCurrentPage(currentPage);
            UserConditions userConditions = new UserConditions();
            if (userAccount != null){
                userConditions.setUser_account(userAccount);
            }
            if (userNickname != null){
                userConditions.setUser_nickname(userNickname);
            }
            if (userTotalscore != null){
                userConditions.setUser_totalscore(userTotalscore);
            }
            if (userStatus != null){
                userConditions.setUser_status(userStatus);
            }
            backendBiz.findUsersByConditionsByPage(page,userConditions);
            List<UserEntity> userEntityList = page.getPageList();
            data.put("users",userEntityList);
            code = 321;
        }else {
            code = 313;
        }
        setMessageByCode();
        return SUCCESS;
    }
    @Action(value = "findStoresByConditionByPage",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String findStoresByConditionByPage()throws Exception{
        BackendBiz backendBiz = new BackendBiz();
        Page<StoreEntity> page = new Page<StoreEntity>();
        if (pageSize != null && currentPage != null){
            page.setPageSize(pageSize);
            page.setCurrentPage(currentPage);
            StoreConditions storeConditions = new StoreConditions();
            if (storeAccount != null){
                storeConditions.setStore_account(storeAccount);
            }
            if (storeName != null){
                storeConditions.setStore_name(storeName);
            }
            if (storeStatus != null){
                storeConditions.setStore_status(storeStatus);
            }
            backendBiz.findStoresByConditionByPage(page,storeConditions);
            List<StoreEntity> storeEntityList = page.getPageList();
            data.put("stores",storeEntityList);
            code = 321;
        }else {
            code = 313;
        }
        setMessageByCode();
        return SUCCESS;
    }

    @Action(value = "updateStoreStatus",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String updateStoreStatus()throws Exception{
        BackendBiz backendBiz = new BackendBiz();
        if (storeId != null){
            StoreEntity storeEntity = backendBiz.findStore(storeId);
            storeStatus = (storeStatus.equals("1") ? "0":"1");
            storeEntity.setStoreStatus(storeStatus);
            backendBiz.updateStoreStatus(storeEntity);
            code = 320;
        }else {
            code = 313;
        }
        setMessageByCode();
        return SUCCESS;
    }

    @Action(value = "updateUserStatus",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String updateUserStatus()throws Exception{
        BackendBiz backendBiz = new BackendBiz();
        if (userId != null){
            UserEntity userEntity = backendBiz.findUser(userId);
            userStatus = (userStatus.equals("1") ? "0":"1");
            userEntity.setUserStatus(userStatus);
            backendBiz.updateUserStatus(userEntity);
            code = 320;
        }else {
            code = 313;
        }
        setMessageByCode();
        return SUCCESS;
    }

}
