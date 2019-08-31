package com.tencent.ai.demo.util;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: RequestUtil
 * @DESCRIPT: 请求工具类
 * @AUTHOR: cuizhichao
 * @DATA: 2019/6/21 2:17 PM
 **/
public class RequestUtil {
    private static final String CHARSET = "utf-8";                         //编码格式
    private static final String PREFIX = "--";                            //前缀
    private static final String BOUNDARY = UUID.randomUUID().toString();  //边界标识 随机生成
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";     //内容类型
    private static final String LINEND = "\r\n";

    public static String post(String data, String URL){

        URL url;
        StringBuffer stringBuffer = null;
        try {

        url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");// 提交模式
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        conn.setRequestProperty("Content-Length",""+data.length());
        conn.setRequestProperty("Cache-Control","no-cache");
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        conn.setRequestProperty("Connection","Keep-Alive");
        //链接地址
        conn.connect();
        DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
        writer.write(data.getBytes("UTF-8"));
        //清理当前编辑器的左右缓冲区，并使缓冲区数据写入基础流
        writer.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                conn.getInputStream(),"UTF-8"));
        String str = null;
        stringBuffer = new StringBuffer();
        while ((str = reader.readLine())!=null){
            stringBuffer.append(str);
        }
        System.out.println(stringBuffer.toString());
            reader.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }

}
