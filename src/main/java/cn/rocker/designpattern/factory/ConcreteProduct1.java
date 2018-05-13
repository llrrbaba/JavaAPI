package cn.rocker.designpattern.factory;

/**
 * @author rocker
 * @version V1.0
 * @Description:    产品实现类1
 * @date 2018/5/6 17:11
 */
public class ConcreteProduct1 extends Product{
    @Override
    public void method2() {
        //业务逻辑处理
        System.out.println("ConcreteProduct1 is made...");
    }
}
