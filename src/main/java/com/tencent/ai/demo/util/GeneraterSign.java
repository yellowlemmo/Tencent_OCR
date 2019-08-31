package com.tencent.ai.demo.util;

import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @ClassName: GeneraterSign
 * @DESCRIPT: TODO
 * @AUTHOR: cuizhichao
 * @DATA: 2019/6/21 5:00 PM
 **/
public class GeneraterSign {

    public static String getSign(Map<String,String> paraMap,String appkey) throws UnsupportedEncodingException {
        //排序
        Map<String,String> sortedParams = new TreeMap<>(paraMap);
        Set<Map.Entry<String,String>> entrys = sortedParams.entrySet();
        //遍历排序后的字典，将参数key=value格式凭借
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String,String> param:entrys){
            //sign参数和空值参数不加入计算
            if(param.getValue() != null &&
                    !"".equals(param.getKey().trim()) &&
                    !"sign".equals(param.getKey().trim()) &&
                    !"".equals(param.getValue().trim())){
                try {
                    builder.append(param.getKey().trim()).append("=")
                            .append(URLEncoder.encode(param.getValue().trim(),"UTF-8")).append("&");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("&app_key="+URLEncoder.encode(appkey,"UTF-8"));
        String sign = MD5Util.getMD5(builder.toString()).toUpperCase();
        return sign;
    }

}
