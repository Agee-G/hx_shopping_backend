package com.action;
/**
 * @author:20155808李连芸
 * @date:18/4/19 15 07
 * @description
 */

import com.dao.OrderDao;
import com.entity.OrderConditions;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;

@ParentPackage("json-default")
public class OrderAction extends ActionSupport{
    // 返回JSON数据
    private int code;//code=0 :成功 ；code=xxx :错误码
    private String message;//用户看的错误信息
    private HashMap data = new HashMap();//返回的数据

    private OrderDao orderDao= new OrderDao();

    private String orderId;
    private String orderUserid;
    private String orderStoreid;
    private String orderNum;
    private String orderGoodname;
    private String goodsId;
    private Integer goodsNum;
    private String goodType;
    private Integer orderTotalprice;
    private String orderAddressId;
    private Integer orderStatus;
    private HashMap<String,String[]> orderData = new HashMap<>();//返回的数据

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
    @JSON(serialize=false)
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    @JSON(serialize=false)
    public String getOrderNum() { return orderNum; }
    public void setOrderNum(String orderNum) { this.orderNum = orderNum; }
    @JSON(serialize=false)
    public String getOrderGoodname() { return orderGoodname; }
    public void setOrderGoodname(String orderGoodname) { this.orderGoodname = orderGoodname; }
    @JSON(serialize=false)
    public String getOrderStoreid() { return orderStoreid; }
    public void setOrderStoreid(String orderStoreid) { this.orderStoreid = orderStoreid; }
    @JSON(serialize=false)
    public Integer getOrderStatus() { return orderStatus; }
    public void setOrderStatus(Integer orderStatus) { this.orderStatus = orderStatus; }
    public String getGoodsId() {return goodsId;}
    public void setGoodsId(String goodsId) {this.goodsId = goodsId;}
    @JSON(serialize=false)
    public Integer getGoodsNum() {return goodsNum;}
    public void setGoodsNum(Integer goodsNum) { this.goodsNum = goodsNum; }
    @JSON(serialize=false)
    public String getGoodType() { return goodType; }
    public void setGoodType(String goodType) { this.goodType = goodType; }
    @JSON(serialize=false)
    public Integer getOrderTotalprice() { return orderTotalprice; }
    public void setOrderTotalprice(Integer orderTotalprice) { this.orderTotalprice = orderTotalprice; }
    @JSON(serialize=false)
    public String getOrderAddressId() { return orderAddressId; }
    public void setOrderAddressId(String orderAddressId) { this.orderAddressId = orderAddressId; }
    public OrderDao getOrderDao() { return orderDao; }
    public void setOrderDao(OrderDao orderDao) { this.orderDao = orderDao; }
    @JSON(serialize=false)
    public HashMap<String, String[]> getOrderData() { return orderData; }
    public void setOrderData(HashMap<String, String[]> orderData) { this.orderData = orderData; }
    @JSON(serialize=false)
    public String getOrderUserid() { return orderUserid; }
    public void setOrderUserid(String orderUserid) { this.orderUserid = orderUserid; }

    //立即购买－－生成一个订单和一个订单商品
    @Action(value = "addOrder", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String addOrder(){
        int result = orderDao.addOrder(orderStoreid,goodsId,goodsNum,goodType,orderTotalprice,orderAddressId);
        code = result;
        switch(result) {
            case 0:
                message = "订单添加成功！";
                break;
            case 201:
                message = "商品id不存在";
                break;
            case 202:
                message = "地址id不存在";
                break;
            default:
                message = "出现未知错误，请联系管理员解决此问题。";
                break;
        }
        return SUCCESS;
    }
    //购物车购买－－根据商家不同生成多个订单和多个订单商品
    @Action(value = "addOrders", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String addOrders(){

        int result = orderDao.addOrders(orderData,orderAddressId);

        code = result;
        switch(result) {
            case 0:
                message = "订单信息添加成功！";
                break;
            case 202:
                message = "地址id不存在。";
                break;
            case 203:
                message = "购物车id不存在。";
                break;
            case 204:
                message = "购物车对应的商品ID不存在。";
                break;
            case 211:
                message = "没有传来购物车结算订单和商品信息。";
                break;
            case 212:
                message = "没有传来用户所购买的商家订单的购物车id。";
                break;
            default:
                message = "出现未知错误，请联系管理员解决此问题。";
                break;
        }
        return SUCCESS;
    }
    //订单查询－－任意条件或组合条件都可以：订单状态、订单用户ID、订单商家ID、订单号、商品标题
    @Action(value = "searchOrders", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String searchOrders(){
        OrderConditions orderConditions = new OrderConditions(orderUserid,orderStoreid,orderNum,orderGoodname,orderStatus);
        int result = orderDao.searchOrders(orderConditions);

        code = result;
        switch(result) {
            case 0:
                message = "订单查询成功！";
                break;
            case 201:
                message = "商品id不存在。";
                break;
            case 205:
                message = "没有该查询条件下的订单。";
                break;
            case 206:
                message = "订单没有对应的商店。";
                break;
            default:
                message = "出现未知错误，请联系管理员解决此问题。";
                break;
        }
        return SUCCESS;
    }
    //删除订单－－根据订单id
    @Action(value = "deleteOrder", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String deleteOrder(){
        int result = orderDao.deleteOrder(orderId);

        code = result;
        switch(result) {
            case 0:
                message = "订单删除成功！";
                break;
            case 207:
                message = "订单ID不存在。";
                break;
            default:
                message = "出现未知错误，请联系管理员解决此问题。";
                break;
        }
        return SUCCESS;
    }
    //更新订单状态－－根据订单id
    @Action(value = "updateOrder", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String updateOrder(){
        int result = orderDao.updateOrder(orderId,orderStatus);
        code = result;
        switch(result) {
            case 0:
                message = "订单更新成功！";
                break;
            case 207:
                message = "订单ID不存在。";
                break;
            default:
                message = "出现未知错误，请联系管理员解决此问题。";
                break;
        }
        return SUCCESS;
    }

}
