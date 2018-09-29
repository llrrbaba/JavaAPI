package cn.rocker.designpattern.strategy;

/**
 * @author rocker
 * @version V1.0
 * @Description:    鸭子模型    鸭子实现类
 * @date 2018/9/29 9:51
 */
public class DuckModel extends Duck{

    public DuckModel(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am a duck model");
    }
}
