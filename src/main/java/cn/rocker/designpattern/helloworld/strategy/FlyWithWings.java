package cn.rocker.designpattern.helloworld.strategy;

/**
 * @author rocker
 * @version V1.0
 * @Description:    飞行动作实现  用翼飞
 * @date 2018/9/29 9:40
 */
public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly(){
        System.out.println("I am flying!!!");
    }

}
