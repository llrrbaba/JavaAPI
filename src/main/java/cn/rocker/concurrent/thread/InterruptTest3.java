package cn.rocker.concurrent.thread;

/**
 * Thread.interrupt()方法测试
 * 通过interrupt方法不可以中断处于运行状态的线程；
 * 但是如果配合isInterrupted()能够中断正在运行的线程，
 * 因为调用interrupt方法相当于将中断标志位置为true，
 * 那么可以通过调用isInterrupted()判断中断标志是否被置位来中断线程的执行
 */
public class InterruptTest3 {

    public static void main(String[] args){
        InterruptTest3 test = new InterruptTest3();
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
            int i = 0;
            while(!isInterrupted() && i<Integer.MAX_VALUE){
                System.out.println(i+" while循环");
                i++;
            }
        }
    }

}
