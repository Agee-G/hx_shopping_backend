package com.Utils;

import java.math.BigDecimal;
/**
 * @description：
 * @author：heyi
 * @date：2018/4/29 2:26
 * @version：v1.0
 */
public class Bigdecimal {
    public static Double add(Double d1, Double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();   //即是 b1+b2;
    }

    public static Double subtract(Double d1, Double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue(); //即是b1-b2
    }

    public static Double multiply(Double d1, Double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.multiply(b2).doubleValue(); //即是b1*b2
    }

    public static Double divide(Double d1, Double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.divide(b2).doubleValue();  //即是b1/b2
    }

}
