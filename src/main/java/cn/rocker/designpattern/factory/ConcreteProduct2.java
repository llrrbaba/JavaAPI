package cn.rocker.designpattern.factory;

/**
 * @author rocker
 * @version V1.0
 * @Description:    产品实现类2
 * @date 2018/5/6 17:12
 */
public class ConcreteProduct2 extends Product{
    @Override
    public void method2() {
        //业务处理逻辑
        System.out.println("ConcreteProduct2 is made...");
    }
}
