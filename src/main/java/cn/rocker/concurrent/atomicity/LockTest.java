package cn.rocker.concurrent.atomicity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock()方法
 * 执行多线程环境下的操作
 * 是否能保持原子性
 * 答案是：能
 */
public class LockTest {

    public  int inc = 0;
    Lock lock = new ReentrantLock();

    public  void increase() {
        lock.lock();
        try {
            inc++;
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final LockTest test = new LockTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();

        //每次执行完输出的都是10000，保证了自增操作的原子性
        System.out.println(test.inc);
    }

}
