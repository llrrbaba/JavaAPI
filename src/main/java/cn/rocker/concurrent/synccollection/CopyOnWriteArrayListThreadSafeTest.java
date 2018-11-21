package cn.rocker.concurrent.synccollection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO 未完
 * CopyOnWriteArrayList线程安全测试
 * @author rocker
 * @date 2018/11/20 09:29
 * @since V1.0
 */
public class CopyOnWriteArrayListThreadSafeTest {

    static CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
    public static void main(String[] args) {
        while(true) {
            for(int i=0;i<11;i++)
                cowList.add(i);

            Thread thread1 = new Thread(){
                public void run() {
                    for(int i=0;i<cowList.size();i++)
                        cowList.remove(i);//单纯执行 CopyOnWriteArrayList 的方法是同步的，但是进入这个循环，如果不加锁的话，是不同步的
                }
            };

            Thread thread2 = new Thread(){
                public void run() {
                    for(int i=0;i<cowList.size();i++)
                        cowList.get(i);//单纯执行 CopyOnWriteArrayList 的方法是同步的，但是进入这个循环，如果不加锁的话，是不同步的
                }
            };
            thread1.start();
            thread2.start();
            while(Thread.activeCount()>10)   {

            }
        }
    }

}
