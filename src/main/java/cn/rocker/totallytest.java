package cn.rocker;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rocker
 * @date 2018/11/12 17:23
 * @since V1.0
 */
public class totallytest {

    @Test
    public void test() throws ParseException {
        String timeStr = "20181112172120";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date parse = format.parse(timeStr);
        long l = parse.getTime() / 1000;
        System.out.println(l);
        System.out.println(format.format(new Date(l*1000)));
    }

}
