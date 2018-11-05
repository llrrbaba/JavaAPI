package cn.rocker.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock.tryLock()方法测试
 * 声明lock要在成员变量声明，如果在方法中声明，则每个线程会获取不同的锁，
 * b线程不用等待a线程执行unlock()，就可以调用lock()
 */
public class TryLockTest {

    private List<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //注意这个地方


    public static void main(String[] args)  {
        final TryLockTest test = new TryLockTest();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();
    }


    public void insert(Thread thread) {
        if(lock.tryLock()) {
            try {
                System.out.println(thread.getName()+"得到了锁");
                for(int i=0;i<10;i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {
            }finally {
                System.out.println(thread.getName()+"释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName()+"获取锁失败");
        }
    }

}
