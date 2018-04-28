package com.test;

import com.biz.BackendBiz;
import com.biz.PayBiz;
import org.junit.Test;
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
        String userBankcard = "1";
        Double userBalance = 0.14;
        payBiz.updateUserBalance(userBankcard, userBalance, 1);
        System.out.println(payBiz.getCode());
    }

}
