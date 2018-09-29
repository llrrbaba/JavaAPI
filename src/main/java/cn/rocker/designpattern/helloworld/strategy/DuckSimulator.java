package cn.rocker.designpattern.helloworld.strategy;

import org.junit.Test;

/**
 * @author rocker
 * @version V1.0
 * @Description:    鸭子模拟器   测试类
 * @date 2018/9/29 9:50
 */
public class DuckSimulator {

    //通过构造器设置飞或者叫的具体实现行为
    @Test
    public void testWithConstructor(){
        DuckModel duckModel = new DuckModel();
        duckModel.perforQuack();
        duckModel.perforFly();
    }


    //通过setter设置飞或者叫的具体实现行为
    @Test
    public void testWithSetter(){
        DuckModel duckModel = new DuckModel();
        duckModel.perforQuack();
        duckModel.perforFly();
        duckModel.setFlyBehavior(new FlyRocketPowered());
        duckModel.perforFly();
    }

}
