package cn.rocker.designpattern.helloworld.strategy;

/**
 * @author rocker
 * @version V1.0
 * @Description:    鸭子叫实现   静音
 * @date 2018/9/29 9:44
 */
public class MuteQuack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Silence!!!");
    }

}
