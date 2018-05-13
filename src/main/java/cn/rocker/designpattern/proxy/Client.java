package cn.rocker.designpattern.proxy;

import org.junit.Test;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/5/6 19:15
 */
public class Client {
    @Test
    public void test() {
        RealRequest realRequest = new RealRequest();
        Subject proxy = new Proxy(realRequest);
        proxy.request();
    }
}