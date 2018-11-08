package cn.rocker.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 分配直接缓冲区
 * TODO 这里有个问题就是，直接缓冲区和非直接缓冲区到底有啥区别？
 * @author rocker
 * @date 2018/11/08 14:38
 * @since V1.0
 */
public class DirectBufferTest {

    @Test
    public void testDirectBuffer() throws Exception{
        String infile = "C:\\Users\\zhht\\Desktop\\javanio.txt";
        FileInputStream streamIn = new FileInputStream( infile );
        FileChannel channelIn = streamIn.getChannel();

        String outfile = String.format("C:\\Users\\zhht\\Desktop\\javanio_copy.txt");
        FileOutputStream streamOut = new FileOutputStream( outfile );
        FileChannel channelOut = streamOut.getChannel();

        // 使用allocateDirect，而不是allocate
        ByteBuffer buffer = ByteBuffer.allocateDirect( 1024 );

        while (true) {
            buffer.clear();

            int r = channelIn.read( buffer );

            if (r==-1) {
                break;
            }

            buffer.flip();

            channelOut.write( buffer );
        }

    }

}
