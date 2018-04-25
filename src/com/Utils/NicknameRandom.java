package com.Utils;

/**
 * @Description:
 * @author:20155852郭志伟
 * @date： 2018/4/25 下午2:49
 */
public class NicknameRandom {

    public static String nickname(){

        String[] firsname = { "炽热的", "冷酷的", "疯狂的", "感动的", "无语的", "丽质的", "细挑的", "消瘦的", "单薄的", "彪壮的",
                    "强健的", "秀丽的", "巍峨的", "高耸的", "陡峭的", "大方的", "聪慧的", "俏丽的", "俊秀的", "帅气的", "潇洒的", "迷人的",
                    "魅力的", "美丽的", "可爱的", "陶醉的", "吟诵的", "风铃的", "悦耳的", "清脆的", "动听的", "优美的", "呆滞的", "慧眼的"};
        String[] namelist = { "面具", "茶杯", "水桶", "电视", "手机", "胖墩", "裙子", "风车", "汽车",
                        "尘土", "建筑", "地铁", "飞机", "楼梯", "游戏", "石砖", "台阶", "球鞋", "软件", "纸张", "轮胎",
                        "篮球", "足球", "兵乓球", "忍者", "法师", "将军", "士兵", "AK47", "平底锅", "座椅", "显示器", "游戏机",
                        "PS4", "Switch", "deidei", "眼睛"};
        int a = (int) Math.abs(firsname.length * Math.random());
        int b = (int) Math.abs(namelist.length * Math.random());
        String name= firsname[a] + namelist[b];
        return name;
        }
}
