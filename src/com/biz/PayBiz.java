package com.biz;

import com.dao.PayDao;
import com.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @description：
 * @author：heyi
 * @date：2018/4/25 18:47
 * @version：v1.0
 */
public class PayBiz {
    private PayDao payDao = new PayDao();
    private int code = 0;

    public PayDao getPayDao() {
        return payDao;
    }

    public void setPayDao(PayDao payDao) {
        this.payDao = payDao;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //更新用户余额
    public void updateUserBalance(String userBankcard, Integer userBalance) {
        Transaction tran = null;
        Session session = payDao.currentSession();
        try {
            tran = session.beginTransaction();
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            UserEntity userEntity = session.get(UserEntity.class, userid);
            if (userBankcard=="" || !userBankcard.equals(userEntity.getUserBankcard())) {
                code = 101;//用户绑定银行卡有问题
            }
            else if (userBalance <= 0) {
                code = 102;//充值金额有问题
            }else{
                userEntity.setUserBalance(userEntity.getUserBalance() + userBalance);
                session.merge(userEntity);
            }
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
}
