package com.tencent.ai.demo.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @ClassName: base64Util
 * @DESCRIPT: TODO
 * @AUTHOR: cuizhichao
 * @DATA: 2019/8/31 6:38 PM
 **/
public class base64Util {

    public static String encode() throws IOException {
        File file = new File("/Users/cuizhichao/Desktop/屏幕快照.png");
        InputStream inputStream = null;
        byte [] data = null;
        try {
            inputStream = new FileInputStream(file);
            data = new byte[inputStream.available()];
            inputStream.read(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64Decoder = new BASE64Encoder();
        String base64 = base64Decoder.encode(data);
        System.out.println(base64);
        return base64;
    }

    public static void decode(String base64) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] data = base64Decoder.decodeBuffer(base64);

        OutputStream outputStream = null;

        outputStream = new FileOutputStream("/Users/cuizhichao/Desktop/屏幕快照123.png");
        outputStream.write(data,0,data.length);
    }

    public static void main(String[] args){
        try {
            String base64 = encode();
            decode(base64);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
