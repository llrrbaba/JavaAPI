package cn.rocker.encode;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author rocker
 * @version V1.0
 * @Description:    将汉字编码和解码
 *                    在传递给url的参数中有的汉字可能需要编码，可以用此类中的方法
 * @date 2018/6/27 21:25
 */
public class EncodeHanZi {
    @Test
    public void test() throws UnsupportedEncodingException {
        String text = "京a123456";

        //将汉字编码
        text = URLEncoder.encode(text,"utf-8");
        System.out.println(new String(text));//%E4%BA%ACa123456

        //将编码后的汉字解码
        text = URLDecoder.decode(text,"utf-8");
        System.out.println(text);//京a123456
    }
}
