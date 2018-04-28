package com.test;

import com.Utils.Page;
import com.biz.BackendBiz;
import com.entity.StoreConditions;
import com.entity.StoreEntity;
import com.entity.UserConditions;
import com.entity.UserEntity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 25/04/201814:34
 */
public class BackendBizTest {
    private BackendBiz backendBiz = new BackendBiz();

    //管理员登陆
    @Test
    public void adminLogin() throws Exception {
        UserConditions userConditions = new UserConditions();
        userConditions.setUser_account("1");
        userConditions.setUser_password("133");
        List<UserEntity> userEntityList = backendBiz.adminLogin(userConditions);
        System.out.println("Size:" + userEntityList.size());
    }

    //用户信息查询
    @Test
    public void findUsersByConditionsByPage()throws Exception{
        UserConditions userConditions = new UserConditions();
        userConditions.setUser_account("1");
        userConditions.setUser_nickname("l");
        userConditions.setUser_status("1");
        userConditions.setUser_totalscore(100);
        Page<UserEntity> page = new Page<UserEntity>();
        page.setPageSize(3);
        page.setCurrentPage(1);
        backendBiz.findUsersByConditionsByPage(page,userConditions);
        List<UserEntity> userEntityList = page.getPageList();
        System.out.println("Size:"+userEntityList.size());

    }

    //商家信息查询
    @Test
    public void findStoresByConditionByPage()throws Exception{
        StoreConditions storeConditions = new StoreConditions();
        storeConditions.setStore_account("1");
        storeConditions.setStore_name("orz");
        Page<StoreEntity> page = new Page<StoreEntity>();
        page.setPageSize(3);
        page.setCurrentPage(1);
        backendBiz.findStoresByConditionByPage(page,storeConditions);
        List<StoreEntity> storeEntityList = page.getPageList();
        System.out.println("Size:"+storeEntityList.size());
    }

}