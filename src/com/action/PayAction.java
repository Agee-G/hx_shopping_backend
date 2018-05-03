package com.action;

import com.biz.PayBiz;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;
/**
 * @description：
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

    //注入biz
    private PayBiz payBiz = new PayBiz();

    //用户信息
    private String userBankcard;
    //状态位（收钱，扣钱）
    private Integer status;
    //金额
    private Double money;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
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
            case 120:
                message = "传来的参数有空的";
                break;
            default:
                message = "出现未知错误，请联系管理员解决此问题。";
                break;
        }
    }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public HashMap getData() { return data; }
    public void setData(HashMap data) { this.data = data; }
    public PayBiz getPayBiz() { return payBiz; }
    public void setPayBiz(PayBiz payBiz) { this.payBiz = payBiz; }
    @JSON(serialize = false)
    public Double getMoney() { return money; }
    public void setMoney(Double money) { this.money = money; }
    @JSON(serialize = false)
    public String getUserBankcard() { return userBankcard; }
    public void setUserBankcard(String userBankcard) { this.userBankcard = userBankcard; }
    @JSON(serialize = false)
    public Integer getStatus() {return status; }
    public void setStatus(Integer status) {this.status = status; }

    //用户充值和提现和支付和退款(status=0收钱【充值或退款】，status=1扣钱【提现或支付】)
    @Action(value = "updateUserBalance", results = {
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String updateUserBalance() {
        if (userBankcard == null || money == null|| status == null) {
            code = 120;
        } else {
            payBiz.updateUserBalance(userBankcard, money, status);
            code = payBiz.getCode();
        }
        return SUCCESS;
    }


}
