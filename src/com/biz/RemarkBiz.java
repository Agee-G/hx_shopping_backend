package com.biz;

import com.dao.RemarkDao;
import com.entity.RemarkEntity;

import java.util.UUID;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/22 下午8:33
 */
public class RemarkBiz {
    private RemarkDao remarkDao = new RemarkDao();

    public RemarkDao getRemarkDao() {
        return remarkDao;
    }

    public void setRemarkDao(RemarkDao remarkDao) {
        this.remarkDao = remarkDao;
    }

    public void addRemark(RemarkEntity remarkEntity){
        remarkEntity.setRemarkId(UUID.randomUUID().toString());

        remarkDao.add(remarkEntity);
    }
}
