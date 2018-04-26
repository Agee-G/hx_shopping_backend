package com.action;
import java.io.File;
import com.Utils.Page;
import com.biz.GoodsBiz;
import com.entity.Goods;
import com.entity.GoodsConditions;
import com.entity.GoodsEntity;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.HashMap;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * @author:李连芸
 * @date:18/4/23 15 22
 * @description
 */
@ParentPackage("json-default")
public class GoodsAction {
    // 返回JSON数据
    private int code;//code=0 :成功 ；code=xxx :错误码
    private String message;//用户看的错误信息
    private HashMap data = new HashMap();//返回的数据

    //分页信息:规定如果传来 currentPage:0,pageSize:0  则查询所有记录
    private Page<GoodsEntity> page = new Page<>();
    private Integer currentPage;
    private Integer pageSize;

    //注入biz
    private GoodsBiz goodsBiz = new GoodsBiz();

    //商品信息
    private String goodsId;
    private String goodsName;
    private Integer goodsType;
    private String goodsDetails;
    private Integer goodsPrice;
    private String goodsStoreid;
    private Integer goodsKucun;
    private String goodsStyle;
    //图片上传
    private File upfile;
    private String upfileFileName;

    //查询条件
    private Integer minPrice;
    private Integer maxPrice;
    private Integer price;//1:价格降序 0:价格升序
    private Integer sell;//1:销量降序 0:销量升序

    //setter、getter
    @JSON(serialize=false)
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;

        switch(code) {
            case 0:
                message = "订单添加成功！";
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
    public GoodsBiz getGoodsBiz() { return goodsBiz; }
    public void setGoodsBiz(GoodsBiz goodsBiz) { this.goodsBiz = goodsBiz; }
    @JSON
    public Page<GoodsEntity> getPage() { return page; }
    public void setPage(Page<GoodsEntity> page) { this.page = page; }
    @JSON
    public File getUpfile() { return upfile; }

    public void setUpfile(File upfile) { this.upfile = upfile; }
    @JSON
    public Integer getMinPrice() { return minPrice; }

    public void setMinPrice(Integer minPrice) { this.minPrice = minPrice; }
    @JSON
    public Integer getMaxPrice() { return maxPrice; }

    public void setMaxPrice(Integer maxPrice) { this.maxPrice = maxPrice; }
    @JSON
    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }
    @JSON
    public Integer getSell() { return sell; }

    public void setSell(Integer sell) { this.sell = sell; }

    @JSON
    public Integer getCurrentPage() { return currentPage; }

    public void setCurrentPage(Integer currentPage) { this.currentPage = currentPage; }
    @JSON
    public Integer getPageSize() { return pageSize; }

    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    @JSON
    public String getGoodsId() { return goodsId; }

    public void setGoodsId(String goodsId) { this.goodsId = goodsId; }
    @JSON
    public String getGoodsName() { return goodsName; }

    public void setGoodsName(String goodsName) { this.goodsName = goodsName; }
    @JSON
    public Integer getGoodsType() { return goodsType; }

    public void setGoodsType(Integer goodsType) { this.goodsType = goodsType; }
    @JSON
    public String getGoodsDetails() { return goodsDetails; }

    public void setGoodsDetails(String goodsDetails) { this.goodsDetails = goodsDetails; }
    @JSON
    public Integer getGoodsPrice() { return goodsPrice; }

    public void setGoodsPrice(Integer goodsPrice) { this.goodsPrice = goodsPrice; }
    @JSON
    public String getGoodsStoreid() { return goodsStoreid; }

    public void setGoodsStoreid(String goodsStoreid) { this.goodsStoreid = goodsStoreid;}
    @JSON
    public Integer getGoodsKucun() { return goodsKucun; }

    public void setGoodsKucun(Integer goodsKucun) { this.goodsKucun = goodsKucun; }
    @JSON
    public String getUpfileFileName() { return upfileFileName; }

    public void setUpfileFileName(String upfileFileName) { this.upfileFileName = upfileFileName; }
    @JSON
    public String getGoodsStyle() { return goodsStyle; }

    public void setGoodsStyle(String goodsStyle) { this.goodsStyle = goodsStyle; }

    //商品发布－－添加商品
    @Action(value = "addGoods", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String addGoods()throws Exception{
        if(upfileFileName != null && goodsName != null && goodsType != null && goodsDetails != null && goodsPrice != null && goodsStoreid != null && goodsKucun != null && goodsStyle != null){
            GoodsEntity goodsEntity = new GoodsEntity(goodsName,goodsType,goodsDetails, goodsPrice, goodsStoreid, goodsKucun,goodsStyle);


            //确定文件存放的路径
            //1.获取当前web程序在容器中的物理路径
            ServletContext sctx = ServletActionContext.getServletContext();
            String absSavePath=sctx.getRealPath("/upload");
            //2.判断路径是否存在
            File realpath=new File(absSavePath);
            if(!realpath.exists()){
                realpath.mkdir();//创建上传文件夹
            }
            FileUtils.copyFile(upfile, new File(absSavePath+"/"+upfileFileName));
            String url = "upload/"+upfileFileName;
            ActionContext.getContext().getSession().put("file", "/upload/"+upfileFileName);

            goodsEntity.setGoodsPicture(url);
            goodsBiz.addGoods(goodsEntity);
            code = goodsBiz.getCode();
        }else{
            code = 220;
        }
        setCode(code);
        return SUCCESS;
    }

    //查看商品－－查询商品详情
    @Action(value = "selectGoodsdetial", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String selectGoodsdetial() {
        if (goodsId != null) {
            Goods goods= goodsBiz.selectGoodsdetial(goodsId);
            if(goods != null){
                data.put("goods",goods);
            }else {
                code = 210;//无查询结果
            }
            code = goodsBiz.getCode();
        }else{
            code = 220;//传来的参数有空
        }

        return SUCCESS;
    }

    //查询商品－－根据条件查询
    @Action(value = "selectGoods", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String selectGoods() {
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        GoodsConditions goodsConditions = new GoodsConditions(goodsName,goodsType,goodsStyle,goodsStoreid,minPrice,maxPrice,price,sell);
        goodsBiz.selectGoodsByConditions(page,goodsConditions);
        if (page.getPageList() != null) {
            data.put("goodsList",page.getPageList());
            code = goodsBiz.getCode();
        }else{
            code = 210;//无查询结果
        }
        return SUCCESS;
    }
    //删除商品－－根据商品id删除
    @Action(value = "deleteGoods", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String deleteGoods() {
        if (goodsId != null) {
            goodsBiz.deleteGoods(goodsId);
            goodsBiz.getCode();
        }else{
            code = 220;//传来的参数有空
        }
        return SUCCESS;
    }

    //编辑商品
    @Action(value = "editGoods", results={
            @Result(
                    type = "json", params = {
                    "code", "code",
                    "message", "message",
                    "data", "data"
            })
    })
    public String editGoods() throws IOException{
        if(goodsId != null && upfileFileName != null && goodsName != null && goodsType != null && goodsDetails != null && goodsPrice != null && goodsStoreid != null && goodsKucun != null && goodsStyle != null){
            GoodsEntity goodsEntity = new GoodsEntity(goodsName,goodsType,goodsDetails, goodsPrice, goodsStoreid, goodsKucun,goodsStyle);

            //确定文件存放的路径
            //1.获取当前web程序在容器中的物理路径
            ServletContext sctx = ServletActionContext.getServletContext();
            String absSavePath=sctx.getRealPath("/upload");
            //2.判断路径是否存在
            File realpath=new File(absSavePath);
            if(!realpath.exists()){
                realpath.mkdir();//创建上传文件夹
            }
            FileUtils.copyFile(upfile, new File(absSavePath+"/"+upfileFileName));
            String url = "upload/"+upfileFileName;
            ActionContext.getContext().getSession().put("file", "/upload/"+upfileFileName);

            goodsEntity.setGoodsPicture(url);
            goodsBiz.editGoods(goodsEntity);
            code = goodsBiz.getCode();
        }else{
            code = 220;
        }
        setCode(code);
        return SUCCESS;
    }


}
