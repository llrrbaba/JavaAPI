package cn.rocker.nio;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel练习
 * @author rocker
 * @date 2018/11/08 10:11
 * @since V1.0
 */
public class FileChannelTest {

    @Test
    public void testFileChannel() throws Exception{
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\zhht\\Desktop\\javanio.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

}
