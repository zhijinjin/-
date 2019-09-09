package com.lanhai.yiqishun;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Text {


    public static void main(String[] args) throws Exception{
        List<String> list = new ArrayList<>();
//        list.add("1_4_7");
//        list.add("1_5_7");
        list.add("1_6_7");
        list.add("2_4_7");
        list.add("2_5_7");
//        list.add("2_6_7");
        list.add("3_4_7");
        list.add("3_5_7");
//        list.add("3_6_7");

        list.add("1_4_8");
        list.add("1_5_8");
//        list.add("1_6_8");
//        list.add("2_4_8");
//        list.add("2_5_8");
//        list.add("2_6_8");
//        list.add("3_4_8");
//        list.add("3_5_8");
//        list.add("3_6_8");

        list.add("1_4_9");
        list.add("1_5_9");
//        list.add("1_6_9");
        list.add("2_4_9");
        list.add("2_5_9");
        list.add("2_6_9");
//        list.add("3_4_9");
//        list.add("3_5_9");
//        list.add("3_6_9");

        Map<String,String> map = new LinkedHashMap();
        map.put("0","2");
        map.put("1","");
        map.put("2","7");

        long start = new Date().getTime();
        String str = getInfoId(list,map);
        System.out.println("耗时："+ (new Date().getTime()-start));

        System.out.println(str);
    }

    /**
     * @param list  id 的有效组合
     * @param map   key 为规格分组的下标
     * @return   可用id
     */
    static String getInfoId(List<String> list,Map<String,String> map){
        String enableIDs = "";
        //遍历每一行分组，判断分组中哪些可以选中
        for(String key:map.keySet()){
            //分组的下标，行
            int index = Integer.valueOf(key);
            //遍历所有有效的id组合，判断能否匹配选中的
            for(String entity:list){
                //假设都可以选中
                boolean flag = true;
                //通过比较非本分组中的选中的id ,判断当前分组中哪些id可以选
                for(String key1:map.keySet()){
                    //遍历分组
                    if(index == Integer.valueOf(key1)){
                        //跳过当前分组
                        continue;
                    }
                    if(!entity.contains(map.get(key1))){
                        //id组合不包含选中的id,则该组合不可选中
                        flag = false;
                    }
                }
                if(flag){
                    //该组合的 对应分组中的id可用
                    if(!enableIDs.contains(entity.split("_")[index])){
                        enableIDs = enableIDs + entity.split("_")[index] + ",";
                    }
                }
            }
        }
        return enableIDs;
    }
}
