package cn.rocker.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ByteBuffer练习
 * 查看 ByteBuffer中的 position，limit，capacity 在不同操作后的变化
 * @author rocker
 * @date 2018/11/08 12:37
 * @since V1.0
 */
public class ByteBufferTest {

    @Test
    public void testByteBuffer() throws Exception{
        FileInputStream fin = new FileInputStream("C:\\Users\\zhht\\Desktop\\javanio.txt");
        FileChannel fc = fin.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(10);
        output("初始化", buffer);

        fc.read(buffer);
        output("调用read()", buffer);

        buffer.flip();
        output("调用flip()", buffer);

        while (buffer.remaining() > 0) {
            byte b = buffer.get();
             System.out.print(((char)b));
        }
        output("调用get()", buffer);

        buffer.clear();
        output("调用clear()", buffer);

        fin.close();
    }

    public static void output(String step, Buffer buffer) {
        System.out.println(step + " : ");
        System.out.print("capacity: " + buffer.capacity() + ", ");
        System.out.print("position: " + buffer.position() + ", ");
        System.out.println("limit: " + buffer.limit());
        System.out.println();
    }


}
