package cn.rocker.socket;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/11/20 20:48
 */
public class InetAddressTest {

    private Logger logger = LoggerFactory.getLogger(InetAddressTest.class);

    @Test
    public void test1() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }

    @Test
    public void test2() throws UnknownHostException {
        InetAddress localHost = InetAddress.getByName("192.168.24.1");
        System.out.println(localHost);
        System.out.println(localHost.getHostName());
    }

}
