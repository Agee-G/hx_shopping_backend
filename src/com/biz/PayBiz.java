package com.biz;

import com.Utils.Bigdecimal;
import com.dao.PayDao;
import com.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

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

    //更新用户余额(status=0收钱【充值或退款】，status=1扣钱【提现或支付】)
    public void updateUserBalance(String userBankcard, Double money, Integer status) {
        Transaction tran = null;
        Session session = payDao.currentSession();
        try {
            tran = session.beginTransaction();
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            UserEntity userEntity = session.get(UserEntity.class, userid);

            if (userBankcard=="" || !userBankcard.equals(userEntity.getUserBankcard())||userBankcard==null) {
                code = 101;//用户绑定银行卡有问题
            }
            else if (money <= 0&&status==0) {
                code = 102;//充值金额有问题
            }
            else if (userEntity.getUserBalance() < money&&status==1) {
                code = 103;//提现金额有问题
            }
            else{
                if(status==0){
                    userEntity.setUserBalance(Bigdecimal.add(userEntity.getUserBalance(),money));
                }
                if(status==1){
                    userEntity.setUserBalance(Bigdecimal.subtract(userEntity.getUserBalance(),money));
                }
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
