package cn.rocker.concurrent.synccollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 比较ArrayList和Vector插入数据时的性能差异
 * 插入同样的数据量，Vector用时几乎是ArrayList的两倍
 * @author rocker
 * @since V1.0
 * @date 2018/11/06 10:19
 */
public class ArrayListAndVectorTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        long start = System.currentTimeMillis();
        for(int i=0;i<800000;i++)
            list.add(i);
        long end = System.currentTimeMillis();
        System.out.println("ArrayList进行800000次插入操作耗时："+(end-start)+"ms");
        start = System.currentTimeMillis();
        for(int i=0;i<800000;i++)
            vector.add(i);
        end = System.currentTimeMillis();
        System.out.println("Vector进行800000次插入操作耗时："+(end-start)+"ms");
    }

}
