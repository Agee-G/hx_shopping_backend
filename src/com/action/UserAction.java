package com.action;

import com.Utils.MD5;
import com.Utils.NicknameRandom;
import com.biz.ShoppingcartBiz;
import com.biz.UserBiz;
import com.dao.ShoppingcartDao;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/25 下午2:38
 */
@ParentPackage("json-default")
public class UserAction extends ActionSupport{
    private String userId;
    private String userAccount;
    private String userPassword;
    private String userNickname;
    private Integer userTotalscore;
    private Integer userScore;
    private Double userBalance;
    private String userBankcard;
    private String userLevel;
    private String userStatus;
    private int code = 0;//code=0 :成功 ；code=xxx :错误码
    private String message;//用户看的错误信息
    private HashMap data = new HashMap();//返回的数据
    private int loginStatus;


    @JSON(serialize=false)
    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    @JSON(serialize=false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    @JSON(serialize=false)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
    @JSON(serialize=false)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }
    @JSON(serialize=false)
    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }
    @JSON(serialize=false)
    public String getUserBankcard() {
        return userBankcard;
    }

    public void setUserBankcard(String userBankcard) {
        this.userBankcard = userBankcard;
    }
    @JSON(serialize=false)
    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
    @JSON(serialize=false)
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
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
            case 3:
                message = "用户已登录";
                code = 0;
                break;
            case 4:
                message = "密码已修改";
                code = 0;
                break;
            case 5:
                message = "昵称已修改";
                code = 0;
                break;
            case 6:
                message = "银行卡已修改";
                break;
            case 7:
                message = "查询成功";
                code = 0;
                break;
            case 400:
                message = "用户未登录";
                break;
            case 411:
                //登录
                message = "用户名和密码错误了诶~ 换一个试试咩(*^▽^*)";
                break;
            case 413:
                //注册
                message = "用户名被人注册了呢o(╥﹏╥)o,慢了一步 呜呜。";
                break;
            case 414:
                message = "为什么我获取不到自己传给自己的值啊。。┭┮﹏┭┮";
                break;
            case 415:
                message = "呜呜呜，这个错误我也不知道为啥了。。";
                break;
            case 420:
                message = "您好，徐先生，您的传参有缺失哦~";
                break;
            default:
                message = "出现了未知错误咩~哭兮兮o(╥﹏╥)o";
                break;
        }
    }
    //用户注册
    @Action(value = "addUser",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String addUser() throws Exception{

        UserBiz userBiz = new UserBiz();

        if(userAccount == null || userPassword == null || userAccount.equals("") || userPassword.equals("")){
            code = 420;
        }else{
            UserEntity userEntity = new UserEntity();
            String valid = userBiz.accountValid(userAccount);
            if(valid == "no"){
                code = 413;
                setMessageByCode();
                return SUCCESS;
            }
            userEntity.setUserAccount(userAccount);


            //MD5加密
            userPassword = MD5.string2MD5(userPassword);
            userEntity.setUserPassword(userPassword);
            userEntity.setUserId(UUID.randomUUID().toString());
            if(userNickname == null || userNickname.equals("")){
                userNickname = NicknameRandom.nickname();
            }
            userEntity.setUserNickname(userNickname);
            userBiz.addUser(userEntity);
            code = 1;
        }
        setMessageByCode();

        return SUCCESS;

    }
    //用户登录
    @Action(value = "userLogin",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String userLogin() throws Exception{
        UserBiz userBiz = new UserBiz();
        String oldpassword = userPassword;
        if(userAccount == null || userPassword == null || userAccount.equals("") || userPassword.equals("")){
            code = 420;
        }else{
            UserEntity userEntity = new UserEntity();
            //MD5加密
            userPassword = MD5.string2MD5(userPassword);
            userBiz.userLogin(userAccount,userPassword);
            System.out.println("Code:"+userBiz.getCode());
            if(userBiz.getCode() == 411){
                code = 411;
            }else{
                code = 2;
                if(loginStatus == 0){
                    ServletActionContext.getRequest().getSession().setMaxInactiveInterval(-1);
                }else{
                    ServletActionContext.getRequest().getSession().setMaxInactiveInterval(3600);
                }
                ServletActionContext.getRequest().getSession().setAttribute("login","yes");
                userEntity = userBiz.selectUserwithlogin(userAccount);
                userEntity.setUserPassword(oldpassword);
                System.out.println(userEntity.getUserPassword());
                data.put("userinfo",userEntity);
                ShoppingcartBiz shoppingcartBiz = new ShoppingcartBiz();
                data.put("shoppingcartcount",shoppingcartBiz.userShoppingcartCount(userEntity.getUserId()));
            }
        }
        setMessageByCode();
        return SUCCESS;
    }

    @Action(value = "isLogin",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String isLogin() throws Exception{

        if(ServletActionContext.getRequest().getSession().getAttribute("login") == null){
            code = 400;
        }else{
            code = 3;
        }
        setMessageByCode();
        return SUCCESS;
    }
    //修改密码、昵称、银行卡
    @Action(value = "editUserinfo",results = {
            @Result(
                    type = "json" , params = {
                    "code","code",
                    "message","message",
                    "data","data"
            })
    })
    public String editUserinfo() throws Exception{
        UserBiz userBiz = new UserBiz();
        Map<String,String> userinfo = new HashMap<>();
        if(userId == null || userId.equals("")){
            code = 420;
            return SUCCESS;
        }
        userinfo.put("user_id",userId);
        if(userPassword != null){
            userPassword = MD5.string2MD5(userPassword);
            userinfo.put("userPassword",userPassword);
            System.out.println(userPassword);
        }
        if(userNickname != null){
            userinfo.put("userNickname",userNickname);
            System.out.println(userNickname);
        }
        if(userBankcard != null){
            userinfo.put("userBankcard",userBankcard);
            System.out.println(userBankcard);
        }
        userBiz.editUserinfo(userinfo);
        code = userBiz.getCode();
        setMessageByCode();
        return SUCCESS;

    }
    /**
     * @description：查询用户等级
     * @author：heyi
     * @date：2018/5/9 20:55
     * @version：v1.0
     */
    //http://localhost:8080/hx_shopping_backend/searchUserlevel.action
    //查询用户等级
    @Action(value = "searchUserlevel", results = {
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String searchUserlevel() {
        UserBiz userBiz = new UserBiz();
        String userlevel = userBiz.searchUserlevel();
        data.put("userlevel", userlevel);
        code = 7;
        setMessageByCode();
        return SUCCESS;
    }

}
