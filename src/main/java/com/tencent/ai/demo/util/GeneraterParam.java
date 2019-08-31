package com.tencent.ai.demo.util;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: GeneraterParam
 * @DESCRIPT: TODO
 * @AUTHOR: cuizhichao
 * @DATA: 2019/6/22 8:52 PM
 **/
public class GeneraterParam {

    public static String getParam(Map<String,String> paraMap){
        Set<Map.Entry<String,String>> entrys = paraMap.entrySet();
        //遍历排序后的字典，将参数key=value格式凭借
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String,String> param:entrys){
            //sign参数和空值参数不加入计算
                try {
                    builder.append(param.getKey().trim()).append("=")
                            .append(URLEncoder.encode(param.getValue().toString().trim(),"utf-8")).append("&");
                }catch (Exception e){
                    e.printStackTrace();
            }
        }

        return builder.deleteCharAt(builder.length()-1).toString();
    }
}
