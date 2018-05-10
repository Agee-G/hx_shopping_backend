package com.test;

import com.Utils.MD5;
import com.biz.StoreBiz;
import com.entity.StoreConditions;
import com.entity.StoreEntity;
import com.entity.StoreapplyEntity;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 28/04/201823:44
 */
public class StoreBizTest {
    private StoreBiz storeBiz = new StoreBiz();
    @Test
    public void addNewStore() throws Exception {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setStoreAccount("gzwdeidei");
        storeEntity.setStorePassword(MD5.string2MD5("gzwdeidei"));
        storeEntity.setStoreName("郭志伟deidei");
        storeBiz.addNewStore(storeEntity);

    }
    @Test
    public void storeLogin()throws Exception{
        StoreConditions storeConditions = new StoreConditions();
        storeConditions.setStore_account("gzwdeidei");
        storeConditions.setStore_password(MD5.string2MD5("gzwdeidei"));
        List<StoreEntity> storeEntityList = storeBiz.storeLogin(storeConditions);
        System.out.println("Size:"+storeEntityList.size());
    }
    @Test
    public void updateStore()throws Exception{
        StoreEntity storeEntity = storeBiz.getStore("d7e7508e-962d-4f77-8a81-58c7a34fab82");
        storeEntity.setStoreName("xmydiaozhale");
        storeBiz.updateStore(storeEntity);
    }
    @Test
    public void addNewStoreApply()throws Exception{
        StoreapplyEntity storeapplyEntity = new StoreapplyEntity();
        storeapplyEntity.setStoreapplyDetail("XMYmeidiao");
        storeapplyEntity.setStoreapplyStoreid("d7e7508e-962d-4f77-8a81-58c7a34fab82");
        storeBiz.addNewStoreApply(storeapplyEntity);
    }
    @Test
    public void findStoreApplyCount()throws Exception{
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setStoreId("1");
        System.out.println("Count:"+storeBiz.findStoreApplyCount(storeEntity));
    }

}