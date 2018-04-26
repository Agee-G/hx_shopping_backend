package com.test;

import com.Utils.Page;
import com.biz.BackendBiz;
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
    @Test
    public void adminLogin() throws Exception {
        UserConditions userConditions = new UserConditions();
        userConditions.setUser_account("1");
        userConditions.setUser_password("133");
        List<UserEntity> userEntityList = backendBiz.adminLogin(userConditions);
        System.out.println("Size:" + userEntityList.size());
    }

    @Test
    public void findUsersByConditionsByPage()throws Exception{
        UserConditions userConditions = new UserConditions();
        userConditions.setUser_account("1");
        userConditions.setUser_nickname("l");
        userConditions.setUser_status(1);
        userConditions.setUser_totalscore(100);
        Page<UserEntity> page = new Page<UserEntity>();
        page.setPageSize(3);
        page.setCurrentPage(1);
        backendBiz.findUsersByConditionsByPage(page,userConditions);
        List<UserEntity> userEntityList = page.getPageList();
        System.out.println("Size:"+userEntityList.size());

    }

}