package cn.rocker.concurrent.thread;

/**
 * Thread.interrupt()方法测试
 * 通过interrupt方法可以中断处于阻塞状态的线程
 */
public class InterruptTest1 {


    public static void main(String[] args){
        InterruptTest1 test = new InterruptTest1();
        MyThread thread = test.new MyThread();
        thread.start();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            try {
                System.out.println("进入睡眠状态");
                Thread.currentThread().sleep(10000);
                System.out.println("睡眠完毕");
            } catch (InterruptedException e) {
                System.out.println("得到中断异常");
            }
            System.out.println("run方法执行完毕");
        }
    }

}
