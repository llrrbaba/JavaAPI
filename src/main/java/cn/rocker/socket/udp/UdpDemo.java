package cn.rocker.socket.udp;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/11/20 21:29
 */
public class UdpDemo {

    /**
     * UDP发送端
     */
    @Test
    public void UdpSend() throws Exception{
        //1.创建udp服务
        DatagramSocket datagramSocket = new DatagramSocket();

        //2.确定数据，封装成数据报包
        byte[] data = "hello udp".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.24.1"), 10000);

        //3.通过socket服务，将数据报包发送
        datagramSocket.send(datagramPacket);

        //4.关闭资源
        datagramSocket.close();
    }


    /**
     * UDP接收端
     */
    @Test
    public void UdpReceive() throws Exception{
        //1.创建udp服务
        DatagramSocket datagramSocket = new DatagramSocket(10000);

        //2.定义数据报包，用于存储数据
        byte[] data = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);

        //3.接收数据
        datagramSocket.receive(datagramPacket);

        //4.获取数据
        String hostName = datagramPacket.getAddress().getHostName();
        System.out.println(hostName);
        String receivedData = new String(data, 0, datagramPacket.getLength());
        System.out.println(receivedData);
        int port = datagramPacket.getPort();
        System.out.println(port);

        //5.关闭资源
        datagramSocket.close();
    }

}
