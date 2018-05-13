package cn.rocker.designpattern.factory;

/**
 * @author rocker
 * @version V1.0
 * @Description:    抽象产品类
 * @date 2018/5/6 17:09
 */
public abstract class Product {
    //产品类的公共方法
    public void method1(){
        //业务处理逻辑
    }

    //抽象方法
    public abstract void method2();
}
