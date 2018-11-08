package cn.rocker.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Buffer切片，创建子缓冲区
 * 分配了一个容量大小为10的缓冲区，并在其中放入了数据0-9，
 * 而在该缓冲区基础之上又创建了一个子缓冲区，并改变子缓冲区中的内容，
 * 从最后输出的结果来看，只有子缓冲区“可见的”那部分数据发生了变化，
 * 并且说明子缓冲区与原缓冲区是数据共享的
 * @author rocker
 * @date 2018/11/08 14:13
 * @since V1.0
 */
public class BufferSliceTest {

    @Test
    public void testBufferSlice(){
        ByteBuffer buffer = ByteBuffer.allocate( 10 );

        // 缓冲区中的数据0-9
        for (int i=0; i<buffer.capacity(); ++i) {
            buffer.put( (byte)i );
        }

        // 创建子缓冲区
        buffer.position( 3 );
        buffer.limit( 7 );
        ByteBuffer slice = buffer.slice();

        // 改变子缓冲区的内容
        for (int i=0; i<slice.capacity(); ++i) {
            byte b = slice.get( i );
            b *= 10;
            slice.put( i, b );
        }

        buffer.position( 0 );
        buffer.limit( buffer.capacity() );

        while (buffer.remaining()>0) {
            System.out.println( buffer.get() );
        }

        buffer.flip();

        //这里回复缓冲区为原来的内容，通过输出，可以发现子缓冲区内容也被恢复了
        for (int i=0; i<buffer.capacity(); ++i) {
            buffer.put( (byte)i );
        }

        buffer.flip();

        while (buffer.remaining()>0) {
            System.out.println( buffer.get() );
        }

    }

}
