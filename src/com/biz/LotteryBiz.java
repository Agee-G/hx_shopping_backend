package com.biz;

import com.Utils.Constants;
import com.dao.LotteryDao;
import com.entity.LotteryEntity;
import com.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class LotteryBiz {
    private LotteryDao lotteryDao = new LotteryDao();
    private int code = 0;

    public LotteryDao getLotteryDao() {
        return lotteryDao;
    }

    public void setLotteryDao(LotteryDao lotteryDao) {
        this.lotteryDao = lotteryDao;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //查询或更新积分 status=0【查询】  status=1【扣除积分】 status=2【增加积分】
    public int searchOrUpdateScore(Integer status,Integer addScore) {
        int score =0;
        Transaction tran = null;
        Session session = lotteryDao.currentSession();
        try {
            tran = session.beginTransaction();
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            UserEntity userEntity = session.get(UserEntity.class, userid);
            score = userEntity.getUserScore();

            if (score < Constants.ONE_LOTTERT_SCORE&&status==1) {
                code = 106;//剩余积分不足
            }
            else{
                if(status==0){

                }
                if(status==1){
                    score = score-Constants.ONE_LOTTERT_SCORE;
                    userEntity.setUserScore(score);
                }
                if(status==2){
                    score = score+addScore;
                    userEntity.setUserScore(score);
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
        return score;
    }

    //直接购买
    public void addLottery(Integer addScore){
        Transaction tran = null;
        Session session = lotteryDao.currentSession();
        try {
            tran = session.beginTransaction();
            //String userid = (String)dataSession.get("userid");
            String userid = "1";
            UserEntity userEntity = session.get(UserEntity.class, userid);

            LotteryEntity lotteryEntity = new LotteryEntity();
            lotteryEntity.setLotteryId(UUID.randomUUID().toString());
            lotteryEntity.setLotteryUser(userid);
            lotteryEntity.setLotteryDetail("恭喜"+userEntity.getUserNickname()+"获得"+addScore+"积分");
            lotteryEntity.setCreateAt(new Timestamp(new Date().getTime()));
            lotteryEntity.setUpdateAt(new Timestamp(new Date().getTime()));

            lotteryDao.add(lotteryEntity);
            tran.commit();
        } catch (Exception e) {
            if (tran != null) {
                tran.rollback();
            }
            e.printStackTrace();
        }
    }
}
