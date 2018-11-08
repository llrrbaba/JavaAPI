package cn.rocker.nio;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射文件I/O
 * 内存映射文件I/O是一种读和写文件数据的方法，
 * 它可以比常规的基于流或者基于通道的I/O快的多。
 * 内存映射文件I/O是通过使文件中的数据出现为 内存数组的内容来完成的，
 * 这其初听起来似乎不过就是将整个文件读到内存中，
 * 但是事实上并不是这样。一般来说，只有文件中实际读取或者写入的部分才会映射到内存中
 * @author rocker
 * @date 2018/11/08 14:55
 * @since V1.0
 */
public class MappedByteBufferTest {

    static private final int start = 0;
    static private final int size = 1024;

    @Test
    public void testMappedByteBuffer() throws Exception{
        RandomAccessFile raf = new RandomAccessFile( "C:\\Users\\zhht\\Desktop\\javanio.txt", "rw" );
        FileChannel fc = raf.getChannel();

        MappedByteBuffer mbb = fc.map( FileChannel.MapMode.READ_WRITE,
                start, size );

        mbb.put( 0, (byte)97 );
        mbb.put( 1023, (byte)122 );

        raf.close();

    }

}
