package cn.rocker.exception;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author rocker
 * @version V1.0
 * @Description:    如果捕捉的异常和抛出的异常不匹配会怎样?
 *
 * @date 2018/7/9 17:56
 */
public class CatchUnMatchException {

    @Test
    public void testCatchUnMatchException(){
        System.out.println(getString());
    }

    public String getString(){
        String result = null;
        try {
            new String(result.getBytes(),"utf-8");
        } catch (Exception e) {
            /**
             * 这里只是捕捉了UnsupportedEncodingException，但是没有捕捉NullPointerException
             * 如果抛出NullPointerException，就不会执行到下面的return语句
             */
            e.printStackTrace();
        }

        return result+1;
    }

}
