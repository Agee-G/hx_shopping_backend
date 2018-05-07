package com.action;

import com.biz.PayBiz;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * @description：支付模块
 * @author：heyi
 * @date：2018/4/29 2:25
 * @version：v1.0
 */
@ParentPackage("json-default")
public class PayAction extends ActionSupport {
    // 返回JSON数据
    private int code;//code=0 :成功 ；code=xxx :错误码
    private String message;//用户看的错误信息
    private HashMap data = new HashMap();//返回的数据

//    注入biz
    private PayBiz payBiz = new PayBiz();


    //状态位(status=0【充值】，status=1【提现】)
    private Integer status;
    //金额
    private Double money;
    //订单号
    private List<String> orderIdList;

    @JSON
    public int getCode() {
        return code;
    }
    public void setCode(int code) { this.code = code; }
    @JSON
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    @JSON
    public HashMap getData() { return data; }
    public void setData(HashMap data) { this.data = data; }
    @JSON(serialize = false)
    public PayBiz getPayBiz() { return payBiz; }
    public void setPayBiz(PayBiz payBiz) { this.payBiz = payBiz; }
    @JSON(serialize = false)
    public Double getMoney() { return money; }
    public void setMoney(Double money) { this.money = money; }
    @JSON(serialize = false)
    public Integer getStatus() {return status; }
    public void setStatus(Integer status) {this.status = status; }
    @JSON(serialize = false)
    public List<String> getOrderIdList() { return orderIdList; }
    public void setOrderIdList(List<String> orderIdList) { this.orderIdList = orderIdList; }

    public void setMessageByCode(int code){
        switch (code) {
            case 0:
                message = "订单添加成功！";
                break;
            case 101:
                message = "用户绑定银行卡有问题";
                break;
            case 102:
                message = "充值金额有问题";
                break;
            case 103:
                message = "提现金额有问题";
                break;
            case 104:
                message = "要支付的订单为空";
                break;
            case 105:
                message = "用户余额不足";
                break;
            case 120:
                message = "传来的参数有空的";
                break;
            default:
                message = "出现未知错误，请联系管理员解决此问题。";
                break;
        }
    }
    //http://localhost:8080/hx_shopping_backend/updateUserBalance.action?money=0.14&&status=1
    //用户充值提现(status=0【充值】，status=1【提现】)
    @Action(value = "updateUserBalance", results = {
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String updateUserBalance() {
        if (money == null|| status == null) {
            code = 120;
        } else {
            payBiz.updateUserBalance(money, status);
            setMessageByCode(code);
        }
        return SUCCESS;
    }

    //http://localhost:8080/hx_shopping_backend/userPayByOrder.action?orderIdList=1
    //用户支付
    @Action(value = "userPayByOrder", results = {
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String userPayByOrder() {
        if (orderIdList == null) {
            code = 120;
        } else {
            payBiz.userPayByOrder(orderIdList);
            setMessageByCode(code);
        }
        return SUCCESS;
    }

}
