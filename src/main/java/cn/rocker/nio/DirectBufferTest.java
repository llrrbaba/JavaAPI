package cn.rocker.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 分配直接缓冲区
 * 直接缓冲区是为加快I/O速度，使用一种特殊方式为其分配内存的缓冲区，
 * JDK文档中的描述为：给定一个直接字节缓冲区，
 * Java虚拟机将尽最大努 力直接对它执行本机I/O操作。
 * 也就是说，它会在每一次调用底层操作系统的本机I/O操作之前(或之后)，
 * 尝试避免将缓冲区的内容拷贝到一个中间缓冲区中 或者从一个中间缓冲区中拷贝数据。
 * 要分配直接缓冲区，需要调用allocateDirect()方法，
 * 而不是allocate()方法，使用方式与普通缓冲区并无区别
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
