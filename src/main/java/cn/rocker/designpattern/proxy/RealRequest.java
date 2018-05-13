package cn.rocker.designpattern.proxy;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/5/6 19:00
 */
public class RealRequest implements Subject{
    @Override
    //实现方法
    public void request() {
        //业务处理逻辑
        System.out.println("i am the real object...");
    }

    @Override
    public void request2() {
        //业务处理逻辑
        System.out.println("i am also the real object...");
    }
}
