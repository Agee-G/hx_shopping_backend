package com.action;
/**
 * @author:lily
 * @date:18/4/19 15 07
 * @description
 */

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import java.util.HashMap;

@ParentPackage("json-default")
public class OrderAction {
    // 返回JSON数据
    private int code;//code=0 :成功 ；code=xxx :错误码
    private String message;//用户看的错误信息
    private HashMap data = new HashMap();//返回的数据

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

    private String username;

    @JSON(serialize=false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Action(value = "test", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String test(){

        return "success";
    }

}
