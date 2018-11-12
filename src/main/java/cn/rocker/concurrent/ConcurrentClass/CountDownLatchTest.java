package cn.rocker.concurrent.ConcurrentClass;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 测试 CountDownLatch
 * 利用它可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，
 * 此时就可以利用CountDownLatch来实现这种功能了
 * @author rocker
 * @date 2018/11/12 15:54
 * @since V1.0
 */
public class CountDownLatchTest {

    @Test
    public void testCountDownLatch(){
        //用给定的计数 初始化 CountDownLatch。
        //由于调用了 countDown() 方法，
        //所以在当前计数到达零之前，await 方法会一直受阻塞。
        //之后，会释放所有等待的线程，await 的所有后续调用都将立即返回。
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程1:"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程1:"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程2:"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程2:"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");

            //这个方法会把后面的线程挂起，直到计数器为0
            latch.await();

            //只有两个子线程执行完毕，才会输出这两句话
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
