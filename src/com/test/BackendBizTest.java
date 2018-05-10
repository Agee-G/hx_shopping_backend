package com.test;

import com.Utils.MD5;
import com.Utils.Page;
import com.biz.BackendBiz;
import com.entity.*;
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
        userConditions.setUser_account("admin");
        userConditions.setUser_password(MD5.string2MD5("admin"));
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
    @Test
    public void updateStoreStatus()throws Exception{
        StoreEntity storeEntity = backendBiz.findStore("1");
        storeEntity.setStoreStatus("1");
        backendBiz.updateStoreStatus(storeEntity);
    }
    @Test
    public void updateUserStatus()throws Exception{
        UserEntity userEntity = backendBiz.findUser("1");
        userEntity.setUserStatus("0");
        backendBiz.updateUserStatus(userEntity);
    }
    @Test
    public void findAllApply()throws Exception{
        List<StoreapplyEntity> storeapplyEntities = backendBiz.findAllApply();
        System.out.println("Size:"+storeapplyEntities.size());
    }
    @Test
    public void findApplyByStoreId()throws Exception{
        List<StoreapplyEntity> storeapplyEntities = backendBiz.findApplyByStoreId("d7e7508e-962d-4f77-8a81-58c7a34fab82");
        System.out.println("Size:"+storeapplyEntities.size());
    }
    @Test
    public void updateAppleStatus()throws Exception{
        StoreapplyEntity storeapplyEntity = backendBiz.findStoreApply("8586c12b-d802-4dc8-8aeb-a3cf7041f899");
        storeapplyEntity.setStoreapplyStatus("1");
        backendBiz.updateApplyStatus(storeapplyEntity);
    }

}