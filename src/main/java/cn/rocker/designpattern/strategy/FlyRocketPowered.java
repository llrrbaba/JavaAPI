package cn.rocker.designpattern.strategy;

/**
 * @author rocker
 * @version V1.0
 * @Description:
 * @date 2018/9/29 10:03
 */
public class FlyRocketPowered implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("I am flying with a rocket!!!");
    }

}
