package com.entity;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 27/04/201819:24
 */
public class StoreConditions {
    private String store_account;
    private String store_name;
    private String store_password;
    private String store_status;

    public String getStore_account() {
        return store_account;
    }

    public void setStore_account(String store_account) {
        this.store_account = store_account;
    }

    public String getStore_name() {
        return "%" + store_name + "%";
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_status() {
        return store_status;
    }

    public void setStore_status(String store_status) {
        this.store_status = store_status;
    }

    public String getStore_password() {
        return store_password;
    }

    public void setStore_password(String store_password) {
        this.store_password = store_password;
    }
}
