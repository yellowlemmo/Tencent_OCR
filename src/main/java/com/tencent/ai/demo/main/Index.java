package com.tencent.ai.demo.main;

import com.alibaba.fastjson.JSON;
import com.tencent.ai.demo.util.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @ClassName: Index
 * @DESCRIPT: TODO
 * @AUTHOR: cuizhichao
 * @DATA: 2019/6/21 2:57 PM
 **/
@Controller
public class Index {

    @Value("${tencent.ocr.appid}")
    private  String appid;
    @Value("${tencent.ocr.appkey}")
    private  String appKey;
    @Value("${tencent.ocr.url}")
    private  String url;
    private String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    @RequestMapping(value = "/")
    public String main(){

        return "main";
    }

    @PostMapping(value = "/upload",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String upload(@RequestParam(name = "image") String image) throws IOException {
        Map<String,String> paraMap = new HashMap<>();
        int index = image.indexOf(",");
        String base64 = image.substring(index+1);
        String timstamp = String.valueOf(System.currentTimeMillis()/1000);
        String nonce_str = getCharAndNum.getRandom(32);
        paraMap.put("app_id",appid);
        paraMap.put("image",base64);
        paraMap.put("time_stamp",timstamp);
        paraMap.put("nonce_str",nonce_str);
        String sign = null;
        try {
            sign = GeneraterSign.getSign(paraMap,appKey);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        paraMap.put("sign",sign);
        String content = GeneraterParam.getParam(paraMap);
        String result = RequestUtil.post(content,url);
        return result;
    }
}
