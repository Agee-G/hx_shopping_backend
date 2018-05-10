package com.action;

import com.biz.LotteryBiz;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import java.util.HashMap;

/**
 * @description：抽奖
 * @author：heyi
 * @date：2018/5/10 8:30
 * @version：v1.0
 */
@ParentPackage("json-default")
public class LotteryAction extends ActionSupport {
    // 返回JSON数据
    private int code;//code=0 :成功 ；code=xxx :错误码
    private String message;//用户看的错误信息
    private HashMap data = new HashMap();//返回的数据

    //    注入biz
    private LotteryBiz lotteryBiz = new LotteryBiz();

    //状态位(status=0【充值】，status=1【提现】)
    private Integer status;
    //增加的积分
    private Integer addScore;

    @JSON
    public int getCode() {
        return code;
    }
    public void setCode(int code) {this.code = code; }
    @JSON
    public String getMessage() {  return message; }
    public void setMessage(String message) { this.message = message; }
    @JSON
    public HashMap getData() { return data; }
    public void setData(HashMap data) { this.data = data; }
    @JSON(serialize = false)
    public LotteryBiz getLotteryBiz() { return lotteryBiz; }
    public void setLotteryBiz(LotteryBiz lotteryBiz) { this.lotteryBiz = lotteryBiz; }
    @JSON(serialize = false)
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    @JSON(serialize = false)
    public Integer getAddScore() { return addScore; }
    public void setAddScore(Integer addScore) { this.addScore = addScore; }

    public void setMessageByCode(int code) {
        switch (code) {
            case 0:
                message = "成功！";
                break;
            case 106:
                message = "剩余积分不足";
                break;
            case 120:
                message = "传来的参数有空的";
                break;
            default:
                message = "出现未知错误，请联系管理员解决此问题。";
                break;
        }
    }

    //http://localhost:8080/hx_shopping_backend/searchOrUpdateScore.action?status=0&&addScore=0
    //查询或更新积分 status=0【查询】  status=1【扣除积分(一次抽奖的)】 status=2【增加积分】
    @Action(value = "searchOrUpdateScore", results = {
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String searchOrUpdateScore() {
        int score = lotteryBiz.searchOrUpdateScore(status,addScore);
        data.put("score", score);
        setMessageByCode(code);
        return SUCCESS;
    }

    //http://localhost:8080/hx_shopping_backend/addLottery.action?addScore=0
    //增加抽奖表
    @Action(value = "addLottery", results = {
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String addLottery() {
        lotteryBiz.addLottery(addScore);
        setMessageByCode(code);
        return SUCCESS;
    }

}
