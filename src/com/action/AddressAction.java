package com.action;

import com.Utils.MD5;
import com.biz.AddressBiz;
import com.biz.UserBiz;
import com.entity.AddressEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/5/10 上午8:38
 */
@ParentPackage("json-default")
public class AddressAction extends ActionSupport {
    private String addressId;
    private String address;
    private String addressUsername;
    private String addressPhone;
    private String addressUser;
    private String addressLevel;
    private int code = 0;//code=0 :成功 ；code=xxx :错误码
    private String message;//用户看的错误信息
    private HashMap data = new HashMap();//返回的数据

    @JSON
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @JSON
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JSON
    public HashMap getData() {
        return data;
    }

    public void setData(HashMap data) {
        this.data = data;
    }

    @JSON(serialize=false)
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @JSON(serialize=false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JSON(serialize=false)
    public String getAddressUsername() {
        return addressUsername;
    }

    public void setAddressUsername(String addressUsername) {
        this.addressUsername = addressUsername;
    }

    @JSON(serialize=false)
    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    @JSON(serialize=false)
    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    @JSON(serialize=false)
    public String getAddressLevel() {
        return addressLevel;
    }

    public void setAddressLevel(String addressLevel) {
        this.addressLevel = addressLevel;
    }

    public void setMessageByCode(){
        switch (code){
            case 1:
                message = "添加地址成功";
                code = 0;
                break;
            case 2:
                message = "获取地址成功";
                code = 0;
                break;
            case 3:
                message = "修改地址成功";
                code = 0;
                break;
            case 4:
                message = "删除地址成功";
                code = 0;
                break;
            case 416:
                message = "地址为空呢，亲亲还需要先添加地址呢~";
                break;
            case 420:
                message = "您好，徐先生，您的传参有缺失哦~";
                break;
            default:
                message = "出现了未知错误咩~哭兮兮o(╥﹏╥)o";
                break;
        }
    }
    //添加地址
    @Action(value = "addAddress",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String addAddress() throws Exception{

        AddressBiz addressBiz = new AddressBiz();

        if(address == null || addressUsername == null || addressPhone == null || addressUser == null || address.equals("") || addressUsername.equals("") || addressPhone.equals("") || addressUser.equals("")){
            code = 420;
        }else{
            AddressEntity addressEntity = new AddressEntity();
            int count = addressBiz.defalutAddressCount(addressUser);
            addressEntity.setAddressLevel(count > 0 ? "2" : "1");
            addressEntity.setAddressId(UUID.randomUUID().toString());
            addressEntity.setAddress(address);
            addressEntity.setAddressPhone(addressPhone);
            addressEntity.setAddressUser(addressUser);
            addressEntity.setAddressUsername(addressUsername);
            addressBiz.addAddress(addressEntity);
            code = 1;
        }
        setMessageByCode();
        return SUCCESS;
    }
    //获取用户收货地址
    @Action(value = "selectAddress",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String selectAddress() throws Exception{
        List<AddressEntity> list = null;
        AddressBiz addressBiz = new AddressBiz();
        if(addressUser == null || addressUser.equals("")){
            code = 420;
        }else{
            list = addressBiz.selectAddress(addressUser);
            if(list == null){
                code = 416;
            }else{
                data.put("addresslist",list);
                code = 2;
            }
        }
        setMessageByCode();
        return SUCCESS;
    }
    @Action(value = "editAddressinfo",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String editAddressinfo() throws Exception{
        AddressBiz addressBiz = new AddressBiz();
        if(addressId == null ||address == null || addressUsername == null || addressPhone == null || addressUser == null || addressId.equals("") ||address.equals("") || addressUsername.equals("") || addressPhone.equals("") || addressUser.equals("")){
            code = 420;
        }else{
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setAddressId(addressId);
            addressEntity.setAddress(address);
            addressEntity.setAddressUsername(addressUsername);
            addressEntity.setAddressUser(addressUser);
            addressEntity.setAddressPhone(addressPhone);
            addressBiz.editAddressinfo(addressEntity);
            code = 3;
        }
        setMessageByCode();
        return SUCCESS;
    }
    @Action(value = "deleteAddress",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String deleteAddress() throws Exception{
        AddressBiz addressBiz = new AddressBiz();
        if(addressId == null || addressId.equals("")){
            code = 420;
        }else{
            addressBiz.deleteAddress(addressId);
            code = 4;
        }
        setMessageByCode();
        return SUCCESS;
    }

}
