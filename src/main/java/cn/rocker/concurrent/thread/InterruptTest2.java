package cn.rocker.concurrent.thread;

import java.io.IOException;

/**
 * Thread.interrupt()方法测试
 * 通过interrupt方法不可以中断处于运行状态的线程
 */
public class InterruptTest2 {

    public static void main(String[] args) throws IOException {
        InterruptTest2 test = new InterruptTest2();
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
            while(i<Integer.MAX_VALUE){
                System.out.println(i+" while循环");
                i++;
            }
        }
    }

}
