package com.biz;

import com.Utils.Bigdecimal;
import com.Utils.Constants;
import com.dao.OrderDao;
import com.dao.PayDao;
import com.entity.OrdersEntity;
import com.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.CriteriaImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @description：
 * @author：heyi
 * @date：2018/4/25 18:47
 * @version：v1.0
 */
public class PayBiz {
    private PayDao payDao = new PayDao();
    private OrderDao orderDao = new OrderDao();
    private int code = 0;

    public PayDao getPayDao() {
        return payDao;
    }
    public void setPayDao(PayDao payDao) {
        this.payDao = payDao;
    }
    public OrderDao getOrderDao() { return orderDao; }
    public void setOrderDao(OrderDao orderDao) { this.orderDao = orderDao; }

    public int getCode() { return code; }
    public void setCode(int code) {
        this.code = code;
    }

    //用户充值提现(status=0【充值】，status=1【提现】)
    public void updateUserBalance(Double money, Integer status) {
        Transaction tran = null;
        Session session = payDao.currentSession();
        try {
            tran = session.beginTransaction();
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            UserEntity userEntity = session.get(UserEntity.class, userid);
            Double userBalance = userEntity.getUserBalance();
            String userBankcard = userEntity.getUserBankcard();

            if (userBankcard==""||userBankcard==null) {
                code = 101;//用户绑定银行卡有问题
            }
            else if (money <= 0&&status==0) {
                code = 102;//充值金额有问题
            }
            else if (userBalance < money&&status==1) {
                code = 103;//提现金额有问题
            }
            else{
                if(status==0){
                    userEntity.setUserBalance(Bigdecimal.add(userBalance,money));
                    userEntity.setUpdateAt(new Timestamp(new Date().getTime()));
                }
                if(status==1){
                    userEntity.setUserBalance(Bigdecimal.subtract(userBalance,money));
                    userEntity.setUpdateAt(new Timestamp(new Date().getTime()));
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

    //查询用户可取金额
    public Double searchUserBalance() {
        Double userBalance = null;
        Transaction tran = null;
        Session session = payDao.currentSession();
        try {
            tran = session.beginTransaction();
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            UserEntity userEntity = session.get(UserEntity.class, userid);
            userBalance = userEntity.getUserBalance();
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
        return userBalance;
    }

    //用户支付
    public void userPayByOrder(List<String> orderIdList) {
        Transaction tran = null;
        Session session = payDao.currentSession();
        try {
            tran = session.beginTransaction();
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            UserEntity userEntity = session.get(UserEntity.class, userid);
            UserEntity admin = session.get(UserEntity.class, Constants.ADMIN_ID);
            Double userBalance = userEntity.getUserBalance();
            Double adminBalance = admin.getUserBalance();

            //所有订单总金额
            Double allOrderTotalPrice = 0.0;
            for (String orderId:orderIdList) {
                OrdersEntity ordersEntity = orderDao.get(orderId);
                allOrderTotalPrice = Bigdecimal.add(allOrderTotalPrice,ordersEntity.getOrderTotalprice());
            }

            if (orderIdList.isEmpty()||orderIdList==null) {
                code = 104;//订单为空
            }
            else if (userBalance < allOrderTotalPrice) {
                code = 105;//余额不足
            }
            else{
                for (String orderId:orderIdList) {
                    OrdersEntity ordersEntity = orderDao.get(orderId);
                    //更改订单状态为代发货
                    ordersEntity.setOrderStatus("1");
                    ordersEntity.setUpdateAt(new Timestamp(new Date().getTime()));
                }
                //第三方收款
                admin.setUserBalance(Bigdecimal.add(adminBalance,allOrderTotalPrice));
                admin.setUpdateAt(new Timestamp(new Date().getTime()));

                //用户给第三方
                userEntity.setUserBalance(Bigdecimal.subtract(userBalance,allOrderTotalPrice));
                userEntity.setUpdateAt(new Timestamp(new Date().getTime()));

                session.merge(userEntity);
                session.merge(admin);
            }
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
    }

    //商家退款
    public void RefundByOrder(List<String> orderIdList) {
        Transaction tran = null;
        Session session = payDao.currentSession();
        try {
            tran = session.beginTransaction();
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            UserEntity userEntity = session.get(UserEntity.class, userid);
            UserEntity admin = session.get(UserEntity.class, Constants.ADMIN_ID);

            Double userBalance = userEntity.getUserBalance();
            Double adminBalance = admin.getUserBalance();

            //所有订单总金额
            Double allOrderTotalPrice = 0.0;
            for (String orderId:orderIdList) {
                OrdersEntity ordersEntity = orderDao.get(orderId);
                allOrderTotalPrice = Bigdecimal.add(allOrderTotalPrice,ordersEntity.getOrderTotalprice());
            }

            if (orderIdList.isEmpty()||orderIdList==null) {
                code = 104;//订单为空
            }
            else if (adminBalance < allOrderTotalPrice) {
                code = 105;//余额不足
            }
            else{
                for (String orderId:orderIdList) {
                    OrdersEntity ordersEntity = orderDao.get(orderId);
                    //更改订单状态为已退款
                    ordersEntity.setOrderStatus("7");
                    ordersEntity.setUpdateAt(new Timestamp(new Date().getTime()));
                }
                //第三方退款
                admin.setUserBalance(Bigdecimal.subtract(adminBalance,allOrderTotalPrice));
                admin.setUpdateAt(new Timestamp(new Date().getTime()));

                //用户收第三方
                userEntity.setUserBalance(Bigdecimal.add(userBalance,allOrderTotalPrice));
                userEntity.setUpdateAt(new Timestamp(new Date().getTime()));

                session.merge(userEntity);
                session.merge(admin);
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
