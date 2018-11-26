package cn.rocker.socket.tcp;

import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author rocker
 * @version V1.0
 * @date 2018/11/20 22:16
 */
public class TcpDemo2 {

    @Test
    public void tcpClient() throws Exception{
        //1.创建客户端的Socket服务，指定目的主机和端口
        Socket socket = new Socket("192.168.24.1", 10002);

        //2.发送数据，创建输出流
        OutputStream outputStream = socket.getOutputStream();

        //3.发送数据
        outputStream.write("hello tcp".getBytes());

        //4.接受服务端返回的数据
        InputStream inputStream = socket.getInputStream();

        //5.处理接收到的数据
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));

        //4.关闭资源
        socket.close();

    }


    @Test
    public void tcpServer() throws Exception{
        //1.建立服务端的Socket服务
        ServerSocket serverSocket = new ServerSocket(10002);

        //2.获取客户端对象(accept会阻塞)
        Socket accept = serverSocket.accept();
        String hostName = accept.getInetAddress().getHostName();
        System.out.println(hostName);

        //3.获得客户端传来的数据，获得输入流
        InputStream inputStream = accept.getInputStream();

        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String receivedStr = new String(bytes,0,len);
        System.out.println(receivedStr);

        //4.给客户端回写数据
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("tcp call back".getBytes());

        //5.关闭客户端
        accept.close();
//        serverSocket.close();服务端可关可不关

    }


}
