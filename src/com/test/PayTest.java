package com.test;

import com.biz.PayBiz;

public class PayTest {
    public static void main(String []args){
        PayBiz payBiz = new PayBiz();

        String userBankcard = "a";
        Integer userBalance = 1;
        payBiz.updateUserBalance(userBankcard, userBalance);
        System.out.println(payBiz.getCode());
    }
}
