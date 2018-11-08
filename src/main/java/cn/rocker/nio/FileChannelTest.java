package cn.rocker.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel练习
 * flip(),在一系列通道 读取(read())或放置(put()) 操作之后，调用此方法(flip())为一系列通道 写入(write())或相对获取(get()) 操作做好准备。
 * @author rocker
 * @date 2018/11/08 10:11
 * @since V1.0
 */
public class FileChannelTest {

    /**
     * 用 ByteBuffer 输入内容
     * 1. 从 RandomAccessFile | FileInputStream 获取Channel
     * 2. 创建Buffer
     * 3. 将数据从Channel读取到Buffer中
     */
    @Test
    public void testFileChannel1() throws Exception{
//        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\zhht\\Desktop\\javanio.txt", "rw");
        File file = new File("C:\\Users\\zhht\\Desktop\\javanio.txt");
        FileInputStream inputStream = new FileInputStream(file);
//        FileChannel inChannel = aFile.getChannel();
        FileChannel inChannel = inputStream.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();//read()之后，get()之前要flip()
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
//        aFile.close();
        inputStream.close();
    }


    /**
     * 用 ByteBuffer 输出内容
     * 1. 从FileOutputStream获取Channel
     * 2. 创建Buffer
     * 3. 将数据从Buffer写入到Channel中
     */
    @Test
    public void testFileChannel2() throws Exception{
        File file = new File("C:\\Users\\zhht\\Desktop\\javanio.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        FileChannel channel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String string = "JAVA NIO333";
        buffer.put(string.getBytes());
        buffer.flip();     ////put()之后，write()之前要flip()
        channel.write(buffer);
        channel.close();
        outputStream.close();
    }

}
