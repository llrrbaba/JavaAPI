package cn.rocker.concurrent.thread;


/**
 * Thread.sleep()方法测试
 * sleep相当于让线程睡眠，交出CPU，让CPU去执行其他的任务。
 * 但是有一点要非常注意，sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，
 * 则即使调用sleep方法，其他线程也无法访问这个对象。
 */
public class SleepTest {

    private int i = 10;
    private Object object = new Object();


    public static void main(String[] args){
        SleepTest test = new SleepTest();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread1.start();
        thread2.start();
    }


    class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                }
                System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }

}
