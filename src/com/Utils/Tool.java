package com.Utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by Txm on 22/03/2018.
 */
public class  Tool{
    //获得当前时间戳－－更新时调用
    public  static java.sql.Timestamp currentTimestamp(){
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return timestamp;
    }
    //获得订单号
    public  static String orderNumber(){
        String orderNumber = currentTimestamp().toString();
        orderNumber += UUID.randomUUID().toString().replaceAll("-", "").substring(8);
        return orderNumber;
    }

    //把日期字符串转为java.util.Date
    public static java.util.Date strToDate(String dateStr,String pattern){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(dateStr);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
    //获得前num天的日期
    public static java.util.Date  getDate(int num)throws Exception{
        //得到当前系统日历
        Calendar calendar = Calendar.getInstance();
        //获取近一个num天的日历
        calendar.add(Calendar.DATE, -num);
        //把日历转为日期类型
        Date date = calendar.getTime();

        return date;
    }

}
