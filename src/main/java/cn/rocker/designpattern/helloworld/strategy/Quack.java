package cn.rocker.designpattern.helloworld.strategy;

/**
 * @author rocker
 * @version V1.0
 * @Description:    鸭子叫实现   呱呱
 * @date 2018/9/29 9:43
 */
public class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Quack!!!");
    }

}
