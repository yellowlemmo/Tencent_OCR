package com.tencent.ai.demo.util;

import java.io.DataOutputStream;
import java.util.Date;

/**
 * @ClassName: SecondTimestamp
 * @DESCRIPT: TODO
 * @AUTHOR: cuizhichao
 * @DATA: 2019/6/22 9:24 PM
 **/
public class SecondTimestamp {

    public static String getTimestamp(){
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if(length > 3){
            return String.valueOf(Integer.valueOf(timestamp.substring(0,length-3)));
        }else {
            return "0";

        }
    }
}
