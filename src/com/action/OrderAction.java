package com.action;
/**
 * @author:20155808李连芸
 * @date:18/4/19 15 07
 * @description
 */

import com.Utils.Page;
import com.biz.OrderBiz;
import com.entity.Order;
import com.entity.OrderConditions;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;
import java.util.List;

@ParentPackage("json-default")
public class OrderAction extends ActionSupport{
    // 返回JSON数据
    private int code;//code=0 :成功 ；code=xxx :错误码
    private String message;//用户看的错误信息
    private HashMap data = new HashMap();//返回的数据

    //注入biz
    private OrderBiz orderBiz= new OrderBiz();

    //分页信息:规定如果传来 currentPage:0,pageSize:0  则查询所有记录
    private Page<Order> orderPage = new Page<>();
    private Integer currentPage;
    private Integer pageSize;

    //订单信息
    private String orderId;
    private String orderUserid;
    private String orderStoreid;
    private String orderNum;
    private String orderGoodname;
    private String goodsId;
    private Integer goodsNum;
    private String goodType;
    private Double orderTotalprice;
    private String orderAddressId;
    private String orderStatus;
    private HashMap<String,String[]> orderData = new HashMap<>();//返回的数据

    //setter、getter
    @JSON()
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;

        switch(code) {
            case 0:
                message = "订单添加成功！";
                break;
            case 201:
                message = "商品id不存在";
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
            case 205:
                message = "没有该查询条件下的订单。";
                break;
            case 206:
                message = "订单没有对应的商店。";
                break;
            case 207:
                message = "订单ID不存在。";
                break;
            case 211:
                message = "没有传来购物车结算订单和商品信息。";
                break;
            case 212:
                message = "没有传来用户所购买的商家订单的购物车id。";
                break;
            case 220:
                message = "传来的参数有空的";
                break;
            default:
                message = "出现未知错误，请联系管理员解决此问题。";
                break;
        }

    }
    @JSON()
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @JSON()
    public HashMap getData() {
        return data;
    }
    public void setData(HashMap data) {
        this.data = data;
    }
    public void setOrderBiz(OrderBiz orderBiz) { this.orderBiz = orderBiz; }
    @JSON(serialize=false)
    public Page<Order> getOrderPage() { return orderPage; }
    public void setOrderPage(Page<Order> orderPage) { this.orderPage = orderPage; }
    @JSON(serialize=false)
    public Integer getCurrentPage() { return currentPage; }
    public void setCurrentPage(Integer currentPage) { this.currentPage = currentPage; }
    @JSON(serialize=false)
    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
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
<<<<<<< HEAD
    public Integer getOrderStatus() { return orderStatus; }
    public void setOrderStatus(Integer orderStatus) { this.orderStatus = orderStatus; }
    @JSON(serialize=false)
=======
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
>>>>>>> 2600d4aa21d9e39d5fb60079557369791707e10f
    public String getGoodsId() {return goodsId;}
    public void setGoodsId(String goodsId) {this.goodsId = goodsId;}
    @JSON(serialize=false)
    public Integer getGoodsNum() {return goodsNum;}
    public void setGoodsNum(Integer goodsNum) { this.goodsNum = goodsNum; }
    @JSON(serialize=false)
    public String getGoodType() { return goodType; }
    public void setGoodType(String goodType) { this.goodType = goodType; }
    @JSON(serialize=false)
    public Double getOrderTotalprice() { return orderTotalprice; }
    public void setOrderTotalprice(Double orderTotalprice) { this.orderTotalprice = orderTotalprice; }
    @JSON(serialize=false)
    public String getOrderAddressId() { return orderAddressId; }
    public void setOrderAddressId(String orderAddressId) { this.orderAddressId = orderAddressId; }
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
    //addOrder.action?orderStoreid=&goodsId=&goodsNum=&goodType=&orderTotalprice=&orderAddressId=
    public String addOrder(){
        if(orderStoreid == null || goodsId == null || goodsNum == null || goodType == null || orderTotalprice == null || orderAddressId == null){
            this.setCode(220);
        }else {
            orderBiz.addOrder(orderStoreid,goodsId,goodsNum,goodType,orderTotalprice,orderAddressId);
            this.setCode(orderBiz.getCode());
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
    //addOrders.action?orderData=&&orderAddressId=
    public String addOrders(){
        if (orderData == null || orderAddressId == null){
            this.setCode(220);
        }else{
            orderBiz.addOrders(orderData,orderAddressId);
            this.setCode(orderBiz.getCode());
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
    //searchOrders.action?pageSize=0&currentPage=0&orderUserid=&orderStoreid=&orderNum=&orderGoodname=&orderStatus=
    public String searchOrders(){
        //如果传来的pageSize为0，则查询所有记录
        orderPage.setPageSize(pageSize);
        //如果传来的当前页数为0，则从第一条记录开始查
        orderPage.setCurrentPage(currentPage);
        //设置查询条件
        OrderConditions orderConditions = new OrderConditions(orderUserid,orderStoreid,orderNum,orderGoodname,orderStatus);
        //调接口，执行查询操作
        orderBiz.searchOrders(orderPage,orderConditions);
        //将数据返回给前端
        data.put("count",orderPage.getCount());
        data.put("orderList",orderPage.getPageList());
        this.setCode(orderBiz.getCode());
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
    //deleteOrder.action?orderId=
    public String deleteOrder(){
        if (orderId == null){
            this.setCode(220);
        }else{
            orderBiz.deleteOrder(orderId);
            this.setCode(orderBiz.getCode());
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
    //updateOrder.action?orderId=&orderStatus=
    public String updateOrder(){
        if(orderId == null || orderStatus == null){
            this.setCode(220);
        }else{
            orderBiz.updateOrder(orderId,orderStatus);
            this.setCode(orderBiz.getCode());
        }
        return SUCCESS;
    }

}
