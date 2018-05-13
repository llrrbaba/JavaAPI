package cn.rocker.designpattern.factory;


import org.junit.Test;

/**
 * @author rocker
 * @version V1.0
 * @Description:    用工厂生产产品
 * @date 2018/5/6 17:36
 */
public class Client {
    @Test
    public void test(){
        //创建工厂
        Creator creator = new ConcreteCreator();

        //生产ConcreteProduct1
        ConcreteProduct1 product1 = creator.createProduct(ConcreteProduct1.class);
        product1.method2();

        //生产ConcreteProduct2
        ConcreteProduct2 product2 = creator.createProduct(ConcreteProduct2.class);
        product2.method2();
    }
}
