package com.test;

import com.biz.StoreBiz;
import com.entity.StoreEntity;
import org.junit.Test;

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
        storeEntity.setStoreId("123");
        storeEntity.setStoreAccount("gzwdeidei");
        storeEntity.setStorePassword("111");
        storeEntity.setStoreName("郭志伟deidei");
        storeBiz.addNewStore(storeEntity);

    }

}