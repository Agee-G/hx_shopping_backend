package com.action;

import com.biz.RemarkBiz;
import com.entity.RemarkEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/22 下午8:36
 */
@ParentPackage("json-default")
public class RemarkAction extends ActionSupport{
    private String remarkId;
    private Integer remarkLevel;
    private String remarkDetail;
    private String remarkGoodsid;
    private String remarkStatus;
    private String remarkUserid;
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

    @JSON
    public String getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(String remarkId) {
        this.remarkId = remarkId;
    }
    @JSON
    public Integer getRemarkLevel() {
        return remarkLevel;
    }

    public void setRemarkLevel(Integer remarkLevel) {
        this.remarkLevel = remarkLevel;
    }
    @JSON
    public String getRemarkDetail() {
        return remarkDetail;
    }

    public void setRemarkDetail(String remarkDetail) {
        this.remarkDetail = remarkDetail;
    }
    @JSON
    public String getRemarkGoodsid() {
        return remarkGoodsid;
    }

    public void setRemarkGoodsid(String remarkGoodsid) {
        this.remarkGoodsid = remarkGoodsid;
    }

    @JSON(serialize=false)
    public String getRemarkStatus() {
        return remarkStatus;
    }

    public void setRemarkStatus(String remarkStatus) {
        this.remarkStatus = remarkStatus;
    }
    @JSON
    public String getRemarkUserid() {
        return remarkUserid;
    }

    public void setRemarkUserid(String remarkUserid) {
        this.remarkUserid = remarkUserid;
    }

    public void setMessageByCode(){
        switch (code){
            case 0:
                message = "添加成功";
            case 420:
                message = "您好，徐先生，您的传参有缺失哦~";
            case 401:
                message = "未查询出相应数据，请您换个条件试试呢O(∩_∩)O";
            default:
                message = "出现了未知错误咩~哭兮兮o(╥﹏╥)o";
        }
    }
    //添加评论
    @Action(value = "addRemark",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String addRemark(){
        RemarkBiz remarkBiz = new RemarkBiz();
        if(remarkLevel == null || remarkDetail == null || remarkGoodsid == null || remarkStatus == null || remarkUserid == null){
            code = 420;
        }else{
            RemarkEntity remarkEntity = new RemarkEntity(remarkLevel,remarkDetail,remarkGoodsid,remarkStatus,remarkUserid);
            remarkBiz.addRemark(remarkEntity);
        }
        setMessageByCode();
        return SUCCESS;

    }
    //根据评论等级查询某商品的评论
    @Action(value = "selectRemarkByLevel",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String selectRemarkByLevel(){
        RemarkBiz remarkBiz = new RemarkBiz();
        if(remarkGoodsid == null || remarkGoodsid == "" || remarkLevel == null){
            code = 420;
        }else{
            List list = null;
            list = remarkBiz.selectRemarkByLevel(remarkGoodsid,remarkLevel);
            if(list == null){
                code = 401;
            }else{
                data.put("remarklist",list);

            }
        }
        setMessageByCode();
        return SUCCESS;
    }
    //查询某商品的所有评论
    @Action(value = "selectRemarkByGoodsId",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String selectRemarkByGoodsId(){
        RemarkBiz remarkBiz = new RemarkBiz();
        if(remarkGoodsid == null || remarkGoodsid == ""){
            code = 420;
        }else{
            List list = null;
            list = remarkBiz.selectRemarkByGoodsId(remarkGoodsid);
            if(list == null){
                code = 401;
            }else{
                data.put("remarklist",list);

            }
        }
        setMessageByCode();
        return SUCCESS;
    }

}
