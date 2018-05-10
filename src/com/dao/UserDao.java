package com.dao;

import com.Utils.Page;
import com.entity.RemarkEntity;
import com.entity.UserEntity;
import org.hibernate.Query;

import java.util.List;
import java.util.Map;

/**
 * @author 汤新苗-20155864
 * @Description:${todo}
 * @date 25/04/201808:20
 */
public class UserDao extends BaseDaoImpl<UserEntity>{
    @Override
    public UserEntity load(String id) {
        return super.load(id);
    }

    @Override
    public Long obtainCount(String hql, Object conditions) {
        String hqlx = "select count(userId) " + hql;
        return super.obtainCount(hqlx, conditions);
    }

    @Override
    public List search(String hql, Object conditions) {
        return super.search(hql, conditions);
    }

    @Override
    public List search(Page page, String hql, Object conditions) {

        return super.search(page, hql, conditions);
    }

    public void addUser(UserEntity userEntity){
        String sql = "insert into user (user_id,user_account,user_password,user_nickname)  values(?,?,?,?)";
        Query query = currentSession().createSQLQuery(sql);
        query.setString(0,userEntity.getUserId());
        query.setString(1,userEntity.getUserAccount());
        query.setString(2,userEntity.getUserPassword());
        query.setString(3,userEntity.getUserNickname());
        query.executeUpdate();

    }

    public String loginValid(String userAccount,String userPassword){
        List<UserEntity> list = null;
        String hql = "from UserEntity where userAccount = :userAccount and userPassword = :userPassword";
        Query query = currentSession().createQuery(hql);
        query.setString("userAccount",userAccount);
        query.setString("userPassword",userPassword);
        list = query.list();
        if(list.size() == 0){
            return "no";
        }else{
            return "yes";
        }
    }

    public String accountValid(String userAccount){
        List<UserEntity> list = null;
        String hql = "from UserEntity where userAccount = :userAccount";
        Query query = currentSession().createQuery(hql);
        query.setString("userAccount",userAccount);
        list = query.list();
        if(list.size() == 0){
            return "yes";
        }else{
            return "no";
        }
    }


    public void  updateUserStatus(UserEntity userEntity){
        String hql = "update UserEntity u set u.userStatus = :status where u.userId = :id";
        Query query = currentSession().createQuery(hql);
        query.setString("status",userEntity.getUserStatus());
        query.setString("id",userEntity.getUserId());
        query.executeUpdate();
    }


    public String editUserinfo(Map<String,String> userinfo){
        if(userinfo.get("userPassword") != null){
            String hql = "update UserEntity u set u.userPassword = :userPassword  where u.userId = :user_id";
            Query query = currentSession().createQuery(hql);
            query.setString("userPassword",userinfo.get("userPassword"));
            query.setString("user_id",userinfo.get("user_id"));
            query.executeUpdate();
            return "password edit";
        }else{
            if(userinfo.get("userNickname") != null){
                String hql = "update UserEntity u set u.userNickname = :userNickname  where u.userId = :user_id";
                Query query = currentSession().createQuery(hql);
                query.setString("userNickname",userinfo.get("userNickname"));
                query.setString("user_id",userinfo.get("user_id"));
                query.executeUpdate();
                return "nickname edit";
            }else {
                if(userinfo.get("userbankcard") != null){
                    String hql = "update UserEntity u set u.userBankcard = :userBankcard  where u.userId = :user_id";
                    Query query = currentSession().createQuery(hql);
                    query.setString("userBankcard",userinfo.get("userBankcard"));
                    query.setString("user_id",userinfo.get("user_id"));
                    query.executeUpdate();
                    return "userbankcard edit";
                }else{
                    return "none";
                }
            }
        }

    }
    public List<UserEntity> selectUserwithlogin(String userAccount){
        List<UserEntity> list = null;
        String hql = "from UserEntity where userAccount = :userAccount";
        Query query = currentSession().createQuery(hql);
        query.setString("userAccount",userAccount);
        list = query.list();

        return list;
    }




}
