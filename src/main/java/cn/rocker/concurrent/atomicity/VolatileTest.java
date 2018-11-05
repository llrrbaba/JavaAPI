package cn.rocker.concurrent.atomicity;

/**
 * Volatile关键字
 * 执行多线程环境下的操作
 * 是否能保持原子性
 * 答案是：不能
 */
public class VolatileTest {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                }
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();

        //每次执行完输出的都不是10000，无法保证自增操作的原子性
        System.out.println(test.inc);
    }

}
