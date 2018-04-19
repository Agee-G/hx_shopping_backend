package com.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Txm on 22/03/2018.
 */
public class  Tool{
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
