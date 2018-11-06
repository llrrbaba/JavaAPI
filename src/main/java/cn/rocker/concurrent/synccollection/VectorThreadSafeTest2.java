package cn.rocker.concurrent.synccollection;

import java.util.Vector;

/**
 * Vector的线程安全测试
 * @author rocker
 * @date 2018/11/06 10:35
 * @since V1.0
 */
public class VectorThreadSafeTest2 {

    static Vector<Integer> vector = new Vector<>();
    public static void main(String[] args) {
        while(true) {
            for(int i=0;i<10;i++)
                vector.add(i);

            Thread thread1 = new Thread(){
                public void run() {
                    synchronized (VectorThreadSafeTest2.class) {   //进行额外的同步
                        for(int i=0;i<vector.size();i++)
                            vector.remove(i);//单纯执行vector的方法是同步的，但是进入这个循环，如果不加锁的话，是不同步的
                    }
                }
            };

            Thread thread2 = new Thread(){
                public void run() {
                    synchronized (VectorThreadSafeTest2.class) {
                        for(int i=0;i<vector.size();i++)
                            vector.get(i);//单纯执行vector的方法是同步的，但是进入这个循环，如果不加锁的话，是不同步的
                    }
                }
            };
            thread1.start();
            thread2.start();
            while(Thread.activeCount()>10)   {

            }
        }
    }

}
