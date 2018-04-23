package com.action;

import com.biz.RemarkBiz;
import com.entity.RemarkEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;

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
    private Integer remarkStatus;
    private String remarkUserid;
    private int code;//code=0 :成功 ；code=xxx :错误码
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
    @JSON
    public Integer getRemarkStatus() {
        return remarkStatus;
    }

    public void setRemarkStatus(Integer remarkStatus) {
        this.remarkStatus = remarkStatus;
    }
    @JSON
    public String getRemarkUserid() {
        return remarkUserid;
    }

    public void setRemarkUserid(String remarkUserid) {
        this.remarkUserid = remarkUserid;
    }


//    public String addRemark(){
//        RemarkBiz remarkBiz = new RemarkBiz();
//        if(remarkLevel == null || remarkDetail == null || remarkGoodsid == null || remarkStatus == null || remarkUserid == null){
//            code = 420;
//        }else{
//            RemarkEntity remarkEntity = new RemarkEntity(remarkLevel,remarkDetail,remarkGoodsid,remarkStatus,remarkUserid);
//            remarkBiz.addRemark(remarkEntity);
//        }
//        return
//
//    }

}
