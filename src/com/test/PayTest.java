package com.test;

import com.biz.BackendBiz;
import com.biz.PayBiz;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @author：heyi
 * @date：2018/4/29 2:26
 * @version：v1.0
 */
public class PayTest {
    private PayBiz payBiz = new PayBiz();

    public PayBiz getPayBiz() {
        return payBiz;
    }

    public void setPayBiz(PayBiz payBiz) {
        this.payBiz = payBiz;
    }

    @Test
    public void pay() throws Exception {
        Double userBalance = 0.14;
        payBiz.updateUserBalance(userBalance, 1);
        System.out.println(payBiz.getCode());
    }
    @Test
    public void pay1() throws Exception {
        List<String> orderIdList = new ArrayList<String>();
        orderIdList.add("1");
        orderIdList.add("订单ID9999");
        payBiz.userPayByOrder(orderIdList);
        System.out.println(payBiz.getCode());
    }

    @Test
    public void pay2() throws Exception {
        List<String> orderIdList = new ArrayList<String>();
        orderIdList.add("1");
        orderIdList.add("订单ID9999");
        payBiz.RefundByOrder(orderIdList);
        System.out.println(payBiz.getCode());
    }
    @Test
    public void pay3() throws Exception {
        payBiz.searchUserBalance();
        System.out.println(payBiz.getCode());
    }


}
